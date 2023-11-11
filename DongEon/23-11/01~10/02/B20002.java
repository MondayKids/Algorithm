package baekjoon.backjoon11.day0110.day02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
사과나무
https://www.acmicpc.net/problem/20002
 */
public class B20002 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] board = new int[n][n];



    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] prefix = new int[n+1][n+1];

    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j < n+1; j++) {
        prefix[i][j] = board[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
      }
    }

    int answer = -1000;

    for(int k = 1; k < n+1; k++) {
      int number = search(k, prefix);
      answer = Math.max(answer, number);
    }

    System.out.println(answer);

  }

  public static int search(int k, int[][] prefix) {
    int result = -1000;
    int n = prefix.length;

    for(int i = k; i < n; i++) {
      for(int j = k; j < n; j++) {
        int number = prefix[i][j] - prefix[i-k][j] - prefix[i][j-k] + prefix[i-k][j-k];
        result = Math.max(result, number);
      }
    }

    return result;

  }

}
