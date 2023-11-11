package baekjoon.backjoon11.day1120.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1, 2, 3 더하기 5
https://www.acmicpc.net/problem/15990
 */
public class B15990 {

  static int t;
  static int n;
  static long[][] dp;
  static long inf = 1_000_000_009;

  public static void main(String[] args) throws IOException {
    dp = new long[100_001][4];

    dp[1][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;

    for(int i = 4; i < 100_001; i++) {
      dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % inf;
      dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % inf;
      dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % inf;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < t; i++) {
      n = Integer.parseInt(br.readLine());
      long answer = (dp[n][1] + dp[n][2] + dp[n][3]) % inf;
      sb.append(answer).append("\n");
    }

    System.out.println(sb);

  }

}
