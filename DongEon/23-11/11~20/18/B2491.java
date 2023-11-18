package baekjoon.backjoon11.day1120.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2491 {

  static int n;
  static int[] board;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    int prev = board[0];


    int maxNumber = 1;
    int minNumber = 1;
    int answer = 1;

    for(int i = 1; i < n; i++) {
      if(prev >= board[i]) {
        maxNumber += 1;
      }
      else {
        maxNumber = 1;
      }

      if(prev <= board[i]) {
        minNumber += 1;
      }
      else {
        minNumber = 1;
      }

      prev = board[i];
      int result = Math.max(maxNumber, minNumber);
      answer = Math.max(answer, result);
    }

    System.out.println(answer);

  }

}
