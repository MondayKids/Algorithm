package baekjoon.backjoon11.day0110.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
문제
https://www.acmicpc.net/problem/14916
 */

public class B14916 {

  static int n;
  static int[] dp;
  static int INF = 987654321;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new int[100001];
    Arrays.fill(dp, INF);

    dp[2] = 1;
    dp[4] = 2;
    dp[5] = 1;

    for(int i = 6; i < 100001; i++) {
      dp[i] = Math.min(dp[i-2] + 1, dp[i-5] + 1);
    }

    int answer = dp[n];
    if(answer == INF) {
      answer = -1;
    }

    System.out.println(answer);

  }

}
