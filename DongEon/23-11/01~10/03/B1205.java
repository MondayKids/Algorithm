package baekjoon.backjoon11.day0110.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1205 {

  static int n, p;
  static long score;
  static List<Long> scores;
  static List<Long> rank;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    score = Long.parseLong(st.nextToken());
    p = Integer.parseInt(st.nextToken());

    if(n == 0) {
      System.out.println(1);
      return;
    }

    scores = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      scores.add(Long.parseLong(st.nextToken()));
    }

    Collections.sort(scores, Collections.reverseOrder());

    // 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.
    if(scores.size() == p) {
      if(scores.get(p-1) >= score) {
        System.out.println(-1);
        return;
      }
    }

    int rank = 0;
    for(long data : scores) {
      rank += 1;
      if(score >= data) {
        System.out.println(rank);
        return;
      }
    }
    System.out.println(rank+1);













  }

}
