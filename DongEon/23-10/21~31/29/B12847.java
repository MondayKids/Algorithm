package baekjoon.backjoon10.day2131.day29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
꿀 아르바이트
https://www.acmicpc.net/problem/12847
 */
public class B12847 {

  static int n;
  static int m;
  static long[] board;
  static long[] prefix;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new long[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    prefix = new long[n+1];
    for(int i = 1; i < n+1; i++) {
      prefix[i] = board[i-1] + prefix[i-1];
    }

    long answer = 0;
    for(int i = 0; i < n+1-m; i++) {
      answer = Math.max(answer, prefix[i+m] - prefix[i]);
    }

    System.out.println(answer);


  }

}
