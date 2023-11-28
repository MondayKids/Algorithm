package baekjoon.backjoon11.day2130.day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
두 수의 합
https://www.acmicpc.net/problem/3273
 */
public class B3273 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] board = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }
    int x = Integer.parseInt(br.readLine());

    int start = 0;
    int end = n-1;

    Arrays.sort(board);
    int answer = 0;

    while(start < end) {
      int result = board[start] + board[end];
      if(result == x) {
        answer++;
        start += 1;
      }
      if(result > x) {
        end -= 1;
      }
      if(result < x) {
        start += 1;
      }
    }

    System.out.println(answer);

  }

}
