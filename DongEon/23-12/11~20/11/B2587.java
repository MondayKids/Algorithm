package baekjoon.backjoon12.day1120.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2587 {

  public static void main(String[] args) throws IOException {

    ;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = 5;
    int[] board = new int[n];
    int sum = 0;
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(br.readLine());
      sum += board[i];
    }

    Arrays.sort(board);

    System.out.println((sum / 5));
    System.out.println(board[2]);



  }

}
