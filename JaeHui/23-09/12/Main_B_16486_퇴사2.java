package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_16486_퇴사2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N + 1][2];
        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
            if (i + meetings[i][0] > N + 1) continue;
            dp[i + meetings[i][0]] = Math.max(dp[i + meetings[i][0]], max + meetings[i][1]);
        }
        System.out.println(Math.max(max, dp[N + 1]));
        br.close();
    }
}
