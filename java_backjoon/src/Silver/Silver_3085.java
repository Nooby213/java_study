package Silver;
import java.util.*;
import java.io.*;

public class Silver_3085 {
    // 최대값
    static int max = 1;
    // n * n
    static int N;
    // 사탕판
    static char[][] candy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                candy[i][j] = temp.charAt(j);
            }
        }
        maxEat();
    }
    static void maxEat () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + 1 < N && canChange(i, j, i + 1, j)) {
                    changeCandy(i, j, i + 1, j);
                    arrCheck();
                    changeCandy(i, j, i + 1, j);
                }
                if (j + 1 < N && canChange(i, j, i, j + 1)) {
                    changeCandy(i, j, i, j + 1);
                    arrCheck();
                    changeCandy(i, j, i, j + 1);
                }
                // 최대 개수는 N 이니까 더 이상 조사할 필요 없다.
                if (max == N) {
                    System.out.println(max);
                    return;
                }
            }
        }
        System.out.println(max);
    }
    static boolean canChange(int i1, int j1, int i2, int j2) {
        if (candy[i1][j1] != candy[i2][j2]) {
            return true;
        }
        return false;
    }
    static void changeCandy(int i1, int j1, int i2, int j2) {
        char temp = candy[i1][j1];
        candy[i1][j1] = candy[i2][j2];
        candy[i2][j2] = temp;
    }
    public static void arrCheck() {

        // 가로 체크
        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=0; j<N-1; j++) {
                // 이전 사탕과 동일한 경우 계속 먹는다
                if(candy[i][j] == candy[i][j+1])
                    count ++;
                    // 이전과 다른 사탕인 경우 1로 초기화
                else
                    count = 1;
                // 사탕 최대 개수 저장
                max = Math.max(max, count);
            }
        }

        // 세로 체크
        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=0; j<N-1; j++) {
                if(candy[j][i] == candy[j+1][i])
                    count ++;
                else
                    count = 1;
                max = Math.max(max, count);
            }
        }
    }
}

