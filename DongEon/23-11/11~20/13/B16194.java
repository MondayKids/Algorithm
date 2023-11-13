package baekjoon.backjoon11.day1120.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
카드 구매하기 2
https://www.acmicpc.net/problem/16194

 */
public class B16194 {

  static int n;
  static int[] cost;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    cost = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 1; i < n+1; i++) {
      cost[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n+1];
    dp[1] = cost[1];

    for(int i = 2; i < n+1; i++) {
      int result = cost[i];
      for(int j = 1; j < i; j++) {
        result = Math.min(result, dp[i-j] + cost[j]);
      }
      dp[i] = result;
    }

    System.out.println(dp[n]);

  }
}
