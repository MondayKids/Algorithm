import java.util.Scanner;

// https://www.acmicpc.net/problem/1003
public class Main_B_1003_피보나치함수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i=2; i<=40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++) {
            int N = sc.nextInt();
            sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

}
