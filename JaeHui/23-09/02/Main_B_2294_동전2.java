package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_B_2294_동전2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (set.contains(coin)) continue;
            set.add(coin);

            for (int k = coin; k <= K; k++)
                dp[k] = Math.min(dp[k], 1 + dp[k - coin]);
        }

        if (dp[K] >= 987654321) System.out.println(-1);
        else System.out.println(dp[K]);

        br.close();
    }
}
