package baekjoon.backjoon11.day2130.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
연속부분최대곱
https://www.acmicpc.net/problem/2670
 */
public class B2670 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    double[] board = new double[n];

    for(int i = 0; i < n; i++) {
      board[i] = Double.parseDouble(br.readLine());
    }

    double[] dp = new double[n];
    dp[0] = board[0];

    double answer = 0;
    for(int i = 1; i < n; i++) {
      dp[i] = Math.max(board[i], board[i] * dp[i-1]);
      answer = Math.max(answer, dp[i]);
    }


    System.out.println(String.format("%.3f", answer));

  }

}
