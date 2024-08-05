import java.util.*;

class UserSolution {
    static Territory[][] territory;
    static Map<String, String> alliance = new HashMap<>();
    static Map<String, String> enemy = new HashMap<>();
    static int N;
    static int[] di = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    static String findAlliance(String monarch) {
        if (!alliance.get(monarch).equals(monarch)) {
            alliance.put(monarch, findAlliance(alliance.get(monarch)));
        }
        return alliance.get(monarch);
    }

    static void makeAlliance(String monarchA, String monarchB) {
        String rootA = findAlliance(monarchA);
        String rootB = findAlliance(monarchB);

        if (!rootA.equals(rootB)) {
            alliance.put(rootB, rootA);
        }
    }

    static void makeEnemy(String monarchA, String monarchB) {
        enemy.put(monarchA, monarchB);
        enemy.put(monarchB, monarchA);
    }

    void init(int N, int mSoldier[][], char mMonarch[][][]) {
        this.N = N;
        territory = new Territory[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String nowMonarch = String.valueOf(mMonarch[i][j]);
                territory[i][j] = new Territory(mSoldier[i][j], nowMonarch);
                alliance.put(nowMonarch, nowMonarch);
                enemy.put(nowMonarch, nowMonarch);
            }
        }
    }

    void destroy() {
        territory = null;
        alliance.clear();
        enemy.clear();
    }

    int ally(char mMonarchA[], char mMonarchB[]) {
        String rootA = findAlliance(String.valueOf(mMonarchA));
        String rootB = findAlliance(String.valueOf(mMonarchB));
        makeAlliance(rootA, rootB);
        return 1;
    }

    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
        return -3;
    }

    int recruit(char mMonarch[], int mNum, int mOption) {
        return -1;
    }

    static class Territory {
        public int soldier;
        public String king;

        public Territory() {
        }

        public Territory(int soldier, String king) {
            this.soldier = soldier;
            this.king = king;
        }

        public void setKing(String king) {
            this.king = king;
        }
    }
}
