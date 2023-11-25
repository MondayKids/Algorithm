package baekjoon.backjoon11.day2130.day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
오큰수
https://www.acmicpc.net/problem/17298
 */
public class B17298 {

  static int n;
  static int[] board;
  static int[] answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    board = new int[n];
    for(int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> stack = new Stack<>();
    answer = new int[n];
    Arrays.fill(answer, -1);

    for(int i = 0; i < n; i++) {
      while(!stack.isEmpty() && board[stack.peek()] < board[i]) {
        answer[stack.pop()] = board[i];
      }
      stack.push(i);
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
      sb.append(answer[i]).append(" ");
    }

    System.out.println(sb);



  }



}
