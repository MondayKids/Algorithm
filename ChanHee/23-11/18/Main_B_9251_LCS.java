import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9251
public class Main_B_9251_LCS {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        // 2중 반복문
        for (int i=1; i<=arr1.length; i++) {
            for (int j=1; j<=arr2.length; j++) {
                if (arr1[i-1] == arr2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[arr1.length][arr2.length]);
    }
}
