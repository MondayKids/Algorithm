package baekjoon.backjoon11.day0110.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
N번째 큰 수
https://www.acmicpc.net/problem/2075
 */
public class B2075 {

  static int n;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n][n];

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        pq.add(board[i][j]);
      }
    }

    int answer = 0;
    for(int i = 0; i < n; i++) {
      answer = pq.poll();
    }

    System.out.println(answer);






  }
}
