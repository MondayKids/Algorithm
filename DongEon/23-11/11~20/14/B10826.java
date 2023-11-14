package baekjoon.backjoon11.day1120.day14;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
피보나치 수 4
https://www.acmicpc.net/problem/10826

숫자 범위가 크기 때문에 BigInteger 사용
 */
public class B10826 {

  static int n;
  static BigInteger[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    dp = new BigInteger[10001];
    dp[0] = BigInteger.ZERO;
    dp[1] = BigInteger.ONE;

    for(int i = 2; i < 10001; i++) {
      dp[i] = dp[i-1].add(dp[i-2]);
    }

    System.out.println(dp[n]);


  }
}
