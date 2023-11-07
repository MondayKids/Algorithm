package baekjoon.backjoon11.day0110.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
줄 세우기
https://www.acmicpc.net/problem/2631

풀이 블로그
https://velog.io/@kjihye0340/%EB%B0%B1%EC%A4%80-2631%EC%A4%84%EC%84%B8%EC%9A%B0%EA%B8%B0Java
 */
public class B2631 {

  static int n;
  static int[] board;
  static int[] dp;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n];
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(br.readLine());
    }

    dp = new int[n];
    dp[0] = 1;

    for(int i = 1; i < n; i++) {
      dp[i] = 1;
      for(int j = 0; j < i; j++) {
           if(board[i] > board[j]) {
             dp[i] = Math.max(dp[i], dp[j] + 1);
           }
      }
    }

    int answer = 0;
    for(int i = 0; i < n; i++) {
      answer = Math.max(answer, dp[i]);
    }

    System.out.println(n-answer);







  }
}
