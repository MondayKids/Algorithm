package baekjoon.backjoon11.day1120.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B19598 {

  static int n;
  static PriorityQueue<lecture> lectures;
  static PriorityQueue<lecture> rooms;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    int answer = 0;
    lectures = new PriorityQueue<>(new Comparator<lecture>() {
      @Override
      public int compare(lecture l1, lecture l2) {
        return l1.start - l2.start;
      }
    });

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      lectures.add(new lecture(start, end));
    }

    rooms = new PriorityQueue<>(new Comparator<lecture>() {
      @Override
      public int compare(lecture l1, lecture l2) {
        return l1.end - l2.end;
      }
    });

    while (!lectures.isEmpty()) {
      lecture data = lectures.poll();
      int startTime = data.start;
      rooms.add(data);
      while(true) {
        if(rooms.peek().end <= startTime) {
          rooms.poll();
        }
        else {
          break;
        }
      }
      answer = Math.max(answer, rooms.size());
    }

    System.out.println(answer);



  }

  public static class lecture {
    int start;
    int end;

    lecture(int start, int end) {
      this.start = start;
      this.end = end;
    }

  }


}
