package baekjoon.backjoon12.day0110.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2346 {

  static int n;
  static Deque<Ballon> ballons;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    ballons = new ArrayDeque<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      int index = i+1;
      int number = Integer.parseInt(st.nextToken());

      ballons.addLast(new Ballon(index, number));
    }

    List<Integer> answer = new ArrayList<>();
    Ballon ballon = ballons.poll();
    answer.add(ballon.index);
    int number = ballon.number;

    while(!ballons.isEmpty()) {
      if(number > 0) {
        int count = number - 1;
        while(count-- > 0) {
          ballons.addLast(ballons.pollFirst());
        }
        ballon = ballons.pollFirst();
        answer.add(ballon.index);
        number = ballon.number;
      }
      else if(number < 0) {
        int count = (number * -1) -1;
        while(count-- > 0) {
          ballons.addFirst(ballons.pollLast());
        }
        ballon = ballons.pollLast();
        answer.add(ballon.index);
        number = ballon.number;
      }
    }

    for(int data : answer) {
      System.out.print(data + " ");
    }

  }

  public static class Ballon {
    int index;
    int number;

    Ballon(int index, int number) {
      this.index = index;
      this.number = number;
    }

  }

}
