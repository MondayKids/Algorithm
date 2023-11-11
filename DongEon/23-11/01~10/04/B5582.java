package baekjoon.backjoon11.day0110.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
공통 부분 문자열
https://www.acmicpc.net/problem/5582

 */
public class B5582 {

  static String s1;
  static String s2;
  static int n1;
  static int n2;

  static int[][] dp;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s1 = br.readLine();
    s2 = br.readLine();
    n1 = s1.length();
    n2 = s2.length();

    dp = new int[n1+1][n2+1];
    int answer = 0;

    for(int i = 1; i < n1+1; i++) {
      for(int j = 1; j < n2+1; j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
          answer = Math.max(answer, dp[i][j]);
        }
      }
    }

    System.out.println(answer);


  }
}
