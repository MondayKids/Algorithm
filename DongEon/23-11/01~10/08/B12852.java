package baekjoon.backjoon11.day0110.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1로 만들기 2
https://www.acmicpc.net/problem/12852

bfs를 활용해 Queue로 풀면 시간 초과가 발생한다.
배열과 메모리제이션으로 문제를 푼다.
 */
public class B12852 {



  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int target = Integer.parseInt(br.readLine());

    dot[] dp = new dot[target+1];
    dp[1] = new dot(0, "1");

    for(int i = 2; i < target+1; i++) {

      int selectCount = Integer.MAX_VALUE;
      String selectHistory = "";

      if(i % 3 == 0) {
        selectCount = dp[i/3].count + 1;
        selectHistory = i + " " + dp[i/3].history;
      }

      if(i % 2 == 0) {
        if(selectCount > dp[i/2].count + 1) {
          selectCount = dp[i/2].count + 1;
          selectHistory = i + " " + dp[i/2].history;
        }
      }

      if(selectCount > dp[i-1].count + 1) {
        selectCount = dp[i-1].count + 1;
        selectHistory = i + " " + dp[i - 1].history;
      }

      dp[i] = new dot(selectCount, selectHistory);
    }

    System.out.println(dp[target].count);
    System.out.println(dp[target].history);

  }

  public static class dot {
    int count;
    String history;

    dot(int count, String history) {
      this.count = count;
      this.history = history;
    }
  }


}
