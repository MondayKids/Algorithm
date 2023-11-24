package baekjoon.backjoon11.day2130.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18353 {

  static int n;
  static int[] board;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    board = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    dp = new int[n];
    dp[0] = 1;



    int answer = 1;

    for(int i = 1; i < n; i++) {
      int result = 1;
      for(int j = 0; j < i; j++) {
        if(board[j] > board[i]) {
          result = Math.max(result, dp[j] + 1);
        }
      }
      dp[i] = result;
      answer = Math.max(answer, dp[i]);
    }

    System.out.println(n - answer);
  }


}
