package baekjoon.backjoon10.day2131.day31;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15989 {

  static int t;
  static int n;
  static int[][] dp;

  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    t = Integer.parseInt(br.readLine());
    sb = new StringBuilder();

    dp = new int[10001][4];

    dp[1][1] = 1;
    dp[2][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;

    /*
     오름차순으로 수식 정리

     5로 예를 들면
     수식이 1로 끝나려면 앞에는 다 1이어야 함. 오름차순으로 수식을 정리했으니까
     1+1+1+1+1

     수식이 2로 끝나려면 앞에는 1,2 이여야 함
     1+1+1+2
     1+2+2

     수식이 3으로 끝나려면 앞에는 1,2,3 이여야함
     1+1+3
     2+3

    */
    for(int i = 4; i < 10001; i++) {
      dp[i][1] = dp[i-1][1];
      dp[i][2] = dp[i-2][1] + dp[i-2][2];
      dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
    }

    for(int i = 0; i < t; i++) {
      n = Integer.parseInt(br.readLine());
      simulation();
    }

    System.out.println(sb.toString());

  }

  public static void simulation() {
    int answer = dp[n][1] + dp[n][2] + dp[n][3];
    sb.append(answer).append("\n");
  }

}
