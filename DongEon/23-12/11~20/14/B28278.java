package baekjoon.backjoon12.day1120.day14;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B28278 {

  public static Stack<Integer> stack;
  public static StringBuilder sb;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    stack = new Stack<>();

    int n = Integer.parseInt(br.readLine());
    sb = new StringBuilder();


    while(n-->0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      switch (type) {
        case 1:
          int number = Integer.parseInt(st.nextToken());
          stack.add(number);
          break;
        case 2:
          if(emptyCheck()) {
            sb.append(stack.pop()).append("\n");
          }
          break;
        case 3:
          sb.append(stack.size()).append("\n");
          break;
        case 4:
          if(stack.isEmpty()) sb.append(1);
          else sb.append(0);
          sb.append("\n");
          break;
        case 5:
          if (emptyCheck()) {
            sb.append(stack.peek()).append("\n");
          }
          break;
      }
    }

    System.out.println(sb);


  }

  public static boolean emptyCheck() {
    if(stack.isEmpty()) {
      sb.append("-1").append("\n");
      return false;
    }
    return true;
  }

}
