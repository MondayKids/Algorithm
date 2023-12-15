package baekjoon.backjoon12.day1120.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class B10867 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    while(n-->0) {
      Integer number = Integer.parseInt(st.nextToken());
      set.add(number);
    }
    for(Integer number : set) {
      pq.add(number);
    }

    while(!pq.isEmpty()) {
      System.out.print(pq.poll() + " ");
    }


  }


}
