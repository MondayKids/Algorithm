import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0-1 냅색 -> dp
// https://www.acmicpc.net/problem/12865
public class 냅색 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물건의 개수
        int K = Integer.parseInt(st.nextToken()); // 가방의 개수

        int[] W = new int[N+1]; // 무게 배열
        int[] V = new int[N+1]; // 가치 배열

        int[][] dp = new int[N+1][K+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken()); // 무게
            V[i] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i=1; i<=N; i++) { // 물건
            for (int j=1; j<=K; j++) { // 가방의 무게
                int curWeight = W[i];
                int curValue  = V[i];

                // 가방에 물건을 넣을 수 없는경우
                if (curWeight > j) {
                    dp[i][j] = dp[i-1][j]; // 이전 최대 값
                }
                // 가방에 물건을 넣을 수 있는경우
                else if (curWeight <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-curWeight] + curValue);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
