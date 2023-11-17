package baekjoon.backjoon11.day1120.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class B11060 {

  static int n;
  static int[] board;
  static long[] dp;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    board = new int[n];
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }
    dp = new long[1101];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for(int i = 0; i < n; i++) {
      if(dp[i] >= Integer.MAX_VALUE) continue;

      for(int j = 0; j <= board[i]; j++) {
        dp[i+j] = Math.min(dp[i+j], dp[i]+1);
      }
    }

    if (dp[n - 1] == Integer.MAX_VALUE) {
      System.out.println(-1);
    }
    else {
      System.out.println(dp[n-1]);
    }

  }

}
