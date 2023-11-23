import java.util.Scanner;

// https://www.acmicpc.net/problem/1912
public class Main_B_1912_연속합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n];

        dp[0] = sc.nextInt();
        for (int i=1; i<n; i++) {
            int input = sc.nextInt();

            dp[i] = Math.max(dp[i-1] + input, input);
        }

        int max = Integer.MIN_VALUE;
        for (int data : dp) {
            max = Math.max(max, data);
        }

        System.out.println(max);
    }
}
