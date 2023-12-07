package baekjoon.backjoon12.day0110.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16928 {
  
  static int n; // 사다리의 수 
  static int m; // 뱀의 수
  static int[] board;
  static int[] dp;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[101];
    for(int i = 0; i < n + m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      board[start] = end;
    }

    dp = new int[101];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = 0;
    dfs(1);


    System.out.println(dp[100]);

  }

  public static void dfs(int start) {
    for(int i = 1; i <= 6; i++) {
      int next = start + i;

      if(next > 100) {
        return;
      }

      // 사다리든 뱀이든
      if(board[next] != 0) {
        dp[next] = dp[start] + 1;
        next = board[next];
      }

      if(dp[next] > dp[start] + 1) {
        dp[next] = dp[start] + 1;
        dfs(next);
      }
    }

  }

}
