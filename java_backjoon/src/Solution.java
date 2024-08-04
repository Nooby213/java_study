import java.io.IOException;
import java.util.*;

public class Solution {

    private static Scanner sc;
    private static UserSolution usersolution = new UserSolution();

    static final int MAX_N = 25;
    static final int MAX_L = 10;

    static final int CMD_INIT = 100;
    static final int CMD_DESTROY = 200;
    static final int CMD_ALLY = 300;
    static final int CMD_ATTACK = 400;
    static final int CMD_RECRUIT = 500;

    static int[][] Sol = new int[MAX_N][MAX_N];
    static char[][][] Monarch = new char[MAX_N][MAX_N][MAX_L + 1];

    private static void String2Char(char[] buf, String str) {
        Arrays.fill(buf, (char) 0);
        for (int i = 0; i < str.length(); ++i)
            buf[i] = str.charAt(i);
        buf[str.length()] = '\0';
    }

    private static int run() throws IOException {
        int isOK = 0;

        int mN;
        char[] mMonarchA = new char[MAX_L + 1];
        char[] mMonarchB = new char[MAX_L + 1];
        char[] mGeneral = new char[MAX_L + 1];
        int mOption;
        int num;

        int N = sc.nextInt();
        int cmd, result, check;

        for (int c = 0; c < N; ++c) {

            cmd = sc.nextInt();
            switch (cmd) {
                case CMD_INIT:
                    mN = sc.nextInt();
                    for (int j = 0; j < mN; j++)
                        for (int i = 0; i < mN; i++)
                            Sol[j][i] = sc.nextInt();

                    for (int j = 0; j < mN; j++)
                        for (int i = 0; i < mN; i++)
                            String2Char(Monarch[j][i], sc.next());

                    usersolution.init(mN, Sol, Monarch);
                    isOK = 1;
                    break;

                case CMD_ALLY:
                    String2Char(mMonarchA, sc.next());
                    String2Char(mMonarchB, sc.next());
                    result = usersolution.ally(mMonarchA, mMonarchB);
                    check = sc.nextInt();
                    if (result != check)
                        isOK = 0;
                    break;

                case CMD_ATTACK:
                    String2Char(mMonarchA, sc.next());
                    String2Char(mMonarchB, sc.next());
                    String2Char(mGeneral, sc.next());
                    result = usersolution.attack(mMonarchA, mMonarchB, mGeneral);
                    check = sc.nextInt();
                    if (result != check)
                        isOK = 0;
                    break;

                case CMD_RECRUIT:
                    String2Char(mMonarchA, sc.next());
                    num = sc.nextInt();
                    mOption = sc.nextInt();
                    result = usersolution.recruit(mMonarchA, num, mOption);
                    check = sc.nextInt();
                    if (result != check)
                        isOK = 0;
                    break;
            }
        }
        usersolution.destroy();
        return isOK;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;
        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        sc = new Scanner(System.in);

        T = sc.nextInt();
        MARK = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            if (run() == 1)
                System.out.println("#" + tc + " " + MARK);
            else
                System.out.println("#" + tc + " 0");
        }
        sc.close();
    }
}

class UserSolution {
    static Territory[][] territory;
    static Map<char[], char[]> alliance = new HashMap<>();
    static Map<char[], char[]> enemy = new HashMap<>();
    static int N;
    static int[] di = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    static char[] find(char[] a, Map<char[], char[]> relation) {
        if (!relation.get(a).equals(a)) {
            relation.put(a, find(relation.get(a), relation));
        }
        return relation.get(a);
    }


    static void union(char[] a, char[] b, Map<char[], char[]> relation) {
        char[] rootA = find(a, relation);
        char[] rootB = find(b, relation);

        if (!rootA.equals(rootB)) {
            relation.put(rootB, rootA);
        }
    }

    void init(int N, int mSoldier[][], char mMonarch[][][]) {
        this.N = N;
        territory = new Territory[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                territory[i][j] = new Territory(mSoldier[i][j], mMonarch[i][j]);
                alliance.put(mMonarch[i][j], mMonarch[i][j]);
                enemy.put(mMonarch[i][j], mMonarch[i][j]);
            }
        }
    }

    void destroy() {
        alliance.clear();
        enemy.clear();
        territory = null;
    }

    int ally(char mMonarchA[], char mMonarchB[]) {
        char[] rootA = alliance.get(mMonarchA);
        char[] rootB = alliance.get(mMonarchB);

        if (rootA == null || rootB == null) {
            return -1; // One of the monarchs does not exist
        }

        if (rootA.equals(rootB)) {
            return -1;
        }

        if (enemy.get(mMonarchA).equals(enemy.get(mMonarchB))) {
            return -2;
        }
        union(mMonarchA, mMonarchB, alliance);

        return 1;
    }


    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
        if (find(mMonarchA, alliance).equals(find(mMonarchB, alliance))) {
            return -1;
        }
        char[] kA = find(mMonarchA, alliance);
        char[] kB = find(mMonarchB, alliance);
        boolean att = false;
        int sumA = 0;
        int sumB = 0;
        int[] terB = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Territory now = territory[i][j];
                if (now.king.equals(mMonarchB)) {
                    sumB += now.soldier;
                    terB[0] = i;
                    terB[1] = j;
                    for (int k = 0; k < 8; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                            Territory near = territory[ni][nj];
                            // A 군주 동맹국이라면
                            if (find(near.king, alliance).equals(kA)) {
                                att = true;
                                sumA += near.soldier / 2;
                                near.soldier -= near.soldier / 2;
                            }
                            // B 군구 동맹국이라면
                            else if (find(near.king, alliance).equals(kB)) {
                                sumB += near.soldier / 2;
                                near.soldier -= near.soldier / 2;
                            }
                        }
                    }
                }
            }
        }
        // 공격할 나라 없으면
        if (!att) {
            return -2;
        }
        int end = sumA - sumB;
        if (end > 0) {
            territory[terB[0]][terB[1]] = new Territory(end, mGeneral);
            union(kA, mGeneral, alliance);
            union(kB, mGeneral, enemy);
            return 1;
        } else {
            territory[terB[0]][terB[1]].soldier = end;
            return 0;
        }
    }

    int recruit(char mMonarch[], int mNum, int mOption) {
        int sum = 0;
        if (mOption == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (territory[i][j].king.equals(mMonarch)) {
                        territory[i][j].soldier += mNum;
                        return territory[i][j].soldier;
                    }
                }
            }
        } else {
            char[] alK = find(mMonarch, alliance);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (find(territory[i][j].king, alliance).equals(alK)) {
                        territory[i][j].soldier += mNum;
                        sum += territory[i][j].soldier;
                    }
                }
            }
        }
        return sum;
    }
}

class Territory {
    public int soldier;
    public char[] king;

    public Territory() {

    }

    public Territory(int soldier, char[] king) {
        this.soldier = soldier;
        this.king = king;
    }

    public void setKing(char[] king) {
        this.king = king;
    }
}
