package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B_2579_계단오르기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 2][3];
        for (int i = 1; i <= N; i++)
            dp[i][0] = Integer.parseInt(br.readLine());

        dp[1][1] = dp[1][0];
        dp[2][1] = dp[2][0];
        dp[2][2] = dp[1][0] + dp[2][0];
        for (int i = 3; i <= N; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + dp[i][0];
            dp[i][2] = dp[i - 1][1] + dp[i][0];
        }

        System.out.println(Math.max(dp[N][1], dp[N][2]));
        br.close();
    }
}
