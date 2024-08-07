package b형.삼국지;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserSolutionAnswer {
    static class SNationInfo {
        int x, y, sol;

        SNationInfo(int x, int y, int sol) {
            this.x = x;
            this.y = y;
            this.sol = sol;
        }
    }

    int inputN;
    int[] parent = new int[8625];
    List<Integer>[] UnionList = new List[625];
    List<Integer>[] EnemyList = new List[625];
    SNationInfo[] Nation = new SNationInfo[8625];
    int[][] NationIndex = new int[26][26];
    Map<String, Integer> NationMap = new HashMap<>();
    int NationCount;

    int Find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = Find(parent[x]);
    }

    void Union(int x, int y) {
        x = Find(x);
        y = Find(y);
        if (x != y) {
            parent[y] = x;
            UnionList[x].addAll(UnionList[y]);
            EnemyList[x].addAll(EnemyList[y]);
        }
    }

    int IsSameUnion(int x, int y) {
        x = Find(x);
        y = Find(y);
        return (x == y) ? 1 : 0;
    }

    int IsEnemy(int x, int y) {
        x = Find(x);
        y = Find(y);
        for (int enemy : EnemyList[x]) {
            if (Find(enemy) == y) return 1;
        }
        return 0;
    }

    void MakeEnemy(int x, int y) {
        x = Find(x);
        y = Find(y);
        if (x == y) return;
        if (IsEnemy(x, y) == 1) return;
        EnemyList[x].add(y);
        EnemyList[y].add(x);
    }

    void init(int N, int[][] mSoldier, char[][][] mMonarch) {
        inputN = N;
        int index = 0;
        NationMap.clear();
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                String monarch = String.valueOf(mMonarch[j][i]).trim();
                NationMap.put(monarch, index);
                NationIndex[j][i] = index;
                Nation[index] = new SNationInfo(i, j, mSoldier[j][i]);
                parent[index] = index;
                UnionList[index] = new ArrayList<>();
                EnemyList[index] = new ArrayList<>();
                UnionList[index].add(index);
                index++;
            }
        }
        NationCount = inputN * inputN;
    }

    void destroy() {
        // Optional: clear or reset data structures if needed.
    }

    int ally(char[] mMonarchA, char[] mMonarchB) {
        int a = NationMap.get(String.valueOf(mMonarchA).trim());
        int b = NationMap.get(String.valueOf(mMonarchB).trim());
        if (IsSameUnion(a, b) == 1) {
            return -1;
        }
        if (IsEnemy(a, b) == 1) {
            return -2;
        }
        Union(a, b);
        return 1;
    }

    int attack(char[] mMonarchA, char[] mMonarchB, char[] mGeneral) {
        int a = NationMap.get(String.valueOf(mMonarchA).trim());
        int b = NationMap.get(String.valueOf(mMonarchB).trim());
        int bossA = Find(a), bossB = Find(b);
        if (bossA == bossB) {
            return -1;
        }

        int sx = Math.max(Nation[b].x - 1, 0);
        int ex = Math.min(Nation[b].x + 1, inputN - 1);
        int sy = Math.max(Nation[b].y - 1, 0);
        int ey = Math.min(Nation[b].y + 1, inputN - 1);

        boolean isThereEnemy = false;
        for (int j = sy; j <= ey; j++) {
            for (int i = sx; i <= ex; i++) {
                if (bossA == Find(NationIndex[j][i])) {
                    isThereEnemy = true;
                    break;
                }
            }
        }

        if (!isThereEnemy) {
            return -2;
        }

        MakeEnemy(bossA, bossB);

        int totalSolA = 0;
        int totalSolB = Nation[b].sol;
        Nation[b].sol = 0;
        int moveNum;

        for (int j = sy; j <= ey; j++) {
            for (int i = sx; i <= ex; i++) {
                int nationIndex = NationIndex[j][i];
                if (bossA == Find(nationIndex)) {
                    moveNum = Nation[nationIndex].sol / 2;
                    Nation[nationIndex].sol -= moveNum;
                    totalSolA += moveNum;
                } else if (bossB == Find(nationIndex)) {
                    moveNum = Nation[nationIndex].sol / 2;
                    Nation[nationIndex].sol -= moveNum;
                    totalSolB += moveNum;
                }
            }
        }

        if (totalSolB >= totalSolA) {
            Nation[b].sol = totalSolB - totalSolA;
            return 0;
        }

        UnionList[bossB].remove(Integer.valueOf(b));

        Nation[b].sol = totalSolA - totalSolB;
        Nation[NationCount] = new SNationInfo(Nation[b].x, Nation[b].y, Nation[b].sol);
        NationIndex[Nation[NationCount].y][Nation[NationCount].x] = NationCount;
        NationMap.put(String.valueOf(mGeneral).trim(), NationCount);
        parent[NationCount] = bossA;
        UnionList[bossA].add(NationCount);
        NationCount++;
        return 1;
    }

    int recruit(char[] mMonarch, int mNum, int mOption) {
        int sum = 0;
        if (mOption == 0) {
            int a = NationMap.get(String.valueOf(mMonarch).trim());
            Nation[a].sol += mNum;
            sum = Nation[a].sol;
        } else {
            int boss = Find(NationMap.get(String.valueOf(mMonarch).trim()));
            for (int nation : UnionList[boss]) {
                Nation[nation].sol += mNum;
                sum += Nation[nation].sol;
            }
        }
        return sum;
    }
}
