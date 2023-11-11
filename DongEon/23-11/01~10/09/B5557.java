package baekjoon.backjoon11.day0110.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1학년
https://www.acmicpc.net/problem/5557

참고 : https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-5557-1%ED%95%99%EB%85%84-java
 */
public class B5557 {
  static int n;
  static int[] board;
  static long[][] dp;
  static long answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    board = new int[n];
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    dp = new long[n-1][21];

    dp[0][board[0]] += 1;

    for(int i = 1; i < n-1; i++) {
      for(int num = 0; num <= 20; num++) {
        if(num - board[i] >= 0) {
          dp[i][num] += dp[i-1][num-board[i]];
        }
        if(num + board[i] <= 20) {
          dp[i][num] += dp[i-1][num+board[i]];
        }
      }
    }

    answer = dp[n-2][board[n-1]];
    System.out.println(answer);

  }



}
