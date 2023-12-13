package baekjoon.backjoon12.day1120.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/10866
덱
 */
public class B10866 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Deque<Integer> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    while(n-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String type = st.nextToken();

      if(type.equals("push_front")) {
        int number = Integer.parseInt(st.nextToken());
        deque.addFirst(number);
      }
      else if (type.equals("push_back")) {
        int number = Integer.parseInt(st.nextToken());
        deque.addLast(number);
      }
      else if (type.equals("pop_front")) {
        if(deque.size() == 0) {
          sb.append(-1);
        }
        else {
          sb.append(deque.pollFirst());
        }
        sb.append("\n");
      }
      else if(type.equals("pop_back")) {
        if(deque.size() == 0) {
          sb.append(-1);
        }
        else {
          sb.append(deque.pollLast());
        }
        sb.append("\n");
      }
      else if(type.equals("size")) {
        sb.append(deque.size()).append("\n");
      }
      else if (type.equals("empty")) {
        if(deque.size() == 0) {
          sb.append(1);
        }
        else {
          sb.append(0);
        }
        sb.append("\n");
      }
      else if (type.equals("front")) {
        if (deque.size() == 0) {
          sb.append(-1);
        }
        else {
          sb.append(deque.peekFirst());
        }
        sb.append("\n");
      }
      else if (type.equals("back")) {
        if (deque.size() == 0) {
          sb.append(-1);
        }
        else {
          sb.append(deque.peekLast());
        }
        sb.append("\n");
      }
    }

    System.out.println(sb);

  }

}
