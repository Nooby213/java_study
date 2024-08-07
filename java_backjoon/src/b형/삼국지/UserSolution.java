package b형.삼국지;

import java.util.*;

class UserSolution {
    static Territory[][] territory;
    static Map<String, String> alliance = new HashMap<>();
    static Map<String, String> enemy = new HashMap<>();
    static int N;
    static int[] di = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    static String findAlliance(String monarch) {
        if (!alliance.containsKey(monarch)) {
            alliance.put(monarch, monarch);
        }
        if (!enemy.containsKey(monarch)) {
            enemy.put(monarch, monarch);
        }
        if (!alliance.get(monarch).equals(monarch)) {
            String root = findAlliance(alliance.get(monarch));
            makeEnemy(monarch, enemy.get(root));
            alliance.put(monarch, root);
        }
        return alliance.get(monarch);
    }

    static void makeAlliance(String rootA, String rootB) {
        if (!rootA.equals(rootB)) {
            alliance.put(rootB, rootA);
        }
    }

    static void makeEnemy(String rootA, String rootB) {
        enemy.put(rootA, rootB);
        enemy.put(rootB, rootA);
    }

    void init(int N, int mSoldier[][], char mMonarch[][][]) {
        this.N = N;
        territory = new Territory[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String nowMonarch = String.valueOf(mMonarch[i][j]).trim();
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
        String rootA = findAlliance(String.valueOf(mMonarchA).trim());
        String rootB = findAlliance(String.valueOf(mMonarchB).trim());
        if (rootA.equals(rootB)) {
            return -1;
        } else if (enemy.get(rootA).equals(rootB)) {
            return -2;
        }
        makeAlliance(rootA, rootB);
        return 1;
    }

    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
        String monarchA = String.valueOf(mMonarchA).trim();
        String monarchB = String.valueOf(mMonarchB).trim();
        String rootA = findAlliance(monarchA);
        String rootB = findAlliance(monarchB);
        if (rootA.equals(rootB)) {
            return -1;
        }
        int sumA = 0;
        int sumB = 0;
        boolean fight = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Territory now = territory[i][j];
                if (now.king.equals(monarchB)) {
                    sumB += now.soldier;
                    // 근처 군주 조사
                    for (int k = 0; k < 8; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                            Territory near = territory[ni][nj];
                            // 적군이면 공격 가능하고 A 에 1/2 병사보냄
                            if (findAlliance(near.king).equals(rootA)) {
                                fight = true;
                                sumA += near.soldier / 2;
                                near.soldier -= near.soldier / 2;
                            }
                            // 아군이면 B에 1/2 병사보냄
                            else if (findAlliance(near.king).equals(rootB)) {
                                sumB += near.soldier / 2;
                                near.soldier -= near.soldier / 2;
                            }
                        }
                    }
                    if (!fight) {
                        return -2;
                    }

                    int left = sumA - sumB;
                    if (left >= 0) {
                        return 0;
                    }
                    String general = String.valueOf(mGeneral).trim();
                    territory[i][j] = new Territory(left, general);
                    alliance.put(general, rootA);
                    enemy.put(general, enemy.get(rootA));
                    return 1;
                }
            }
        }
        return -2;
    }

    int recruit(char mMonarch[], int mNum, int mOption) {
        String monarch = String.valueOf(mMonarch).trim();
        if (mOption == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Territory now = territory[i][j];
                    if (now.king.equals(monarch)) {
                        now.soldier += mNum;
                        return now.soldier;
                    }
                }
            }
        }
        String root = findAlliance(monarch);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Territory now = territory[i][j];
                if (findAlliance(now.king).equals(root)) {
                    now.soldier += mNum;
                    sum += now.soldier;
                }
            }
        }
        return sum;
    }

    static class Territory {
        public int soldier;
        public String king;
        public Territory(int soldier, String king) {
            this.soldier = soldier;
            this.king = king;
        }
    }
}
