/*

이항 계수 -> 동적 계획법

N, M 크기가 30이므로 재귀로 풀면 터진다.

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1

1번 성질
n+1 C r+1 = n C r + n C r+1
 */

import java.util.Scanner;

// https://www.acmicpc.net/problem/1010
public class Main_B_1010_다리놓기 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // 2번 성질 (n == r, r == 0)
        for (int i=0; i<30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        /*
        1 0
        1 1 0
        1 0 1 0
        1 0 0 1 0
         */


        for (int i=2; i<30; i++) {
            for (int j=1; j<30; j++) {
                // 1번 성질
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        /*
        1 0
        1 1 0
        1 2 1 0
        1 3 3 1 0
         */



        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            sb.append(dp[M][N]).append("\n");
        }
        System.out.println(sb);
    }

}
