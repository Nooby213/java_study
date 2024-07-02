package gold;

import java.util.Scanner;

public class Gold_11444 {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        // 행렬 초기화
        long[][] baseMatrix = { {1, 1}, {1, 0} };

        // 피보나치 수를 구하기 위한 행렬 거듭제곱 계산
        long[][] resultMatrix = matrixPower(baseMatrix, n - 1);

        // 결과 출력 (F(n))
        System.out.println(resultMatrix[0][0]);
    }

    // 행렬의 거듭제곱을 계산하는 함수
    public static long[][] matrixPower(long[][] matrix, long exp) {
        if (exp == 0) {
            // 항등 행렬 반환
            return new long[][] { {1, 0}, {0, 1} };
        }

        if (exp == 1) {
            // 원래의 행렬 반환
            return matrix;
        }

        // 거듭제곱의 절반을 계산
        long[][] halfPower = matrixPower(matrix, exp / 2);

        // 절반의 거듭제곱을 곱함
        long[][] halfPowerSquared = matrixMultiply(halfPower, halfPower);

        // 만약 지수가 홀수면 원래의 행렬을 한 번 더 곱함
        if (exp % 2 != 0) {
            return matrixMultiply(halfPowerSquared, matrix);
        } else {
            return halfPowerSquared;
        }
    }

    // 두 행렬을 곱하는 함수
    public static long[][] matrixMultiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];

        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;

        return result;
    }
}
