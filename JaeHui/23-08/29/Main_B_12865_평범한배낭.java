package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_12865_평범한배낭 {

    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int dp(int N, int K, Item[] items) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++)
            for (int w = 1; w <= K; w++)
                if (items[i].weight > w) dp[i][w] = dp[i - 1][w];
                else dp[i][w] = Math.max(dp[i - 1][w], items[i].value + dp[i - 1][w - items[i].weight]);

        return dp[N][K];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Item[] items = new Item[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items[i] = new Item(weight, value);
        }

        System.out.println(dp(N, K, items));

        br.close();
    }
}
