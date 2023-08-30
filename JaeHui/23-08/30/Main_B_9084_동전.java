package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_9084_동전 {

    static int solution(int N, int[] coin, int M, int[] dp) {
        dp[0] = 1;

        for (int i = 1; i <= N; i++)
            for (int j = coin[i]; j <= M; j++)
                dp[j] += dp[j - coin[i]];

        return dp[M];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, M;
        int[] dp;

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            int[] coin = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                coin[i] = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];

            sb.append(solution(N, coin, M, dp)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
