package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_2293_동전1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int coin;
        int[] dp = new int[K + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            coin = Integer.parseInt(br.readLine());
            for (int j = coin; j <= K; j++)
                dp[j] += dp[j - coin];
        }

        System.out.println(dp[K]);
        br.close();
    }
}
