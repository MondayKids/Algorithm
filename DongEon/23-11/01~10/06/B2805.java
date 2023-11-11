package baekjoon.backjoon11.day0110.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
나무 자르기
https://www.acmicpc.net/problem/2805
 */
public class B2805 {

  static int n;
  static long m;
  static long[] trees;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Long.parseLong(st.nextToken());

    trees = new long[n];
    st = new StringTokenizer(br.readLine());
    long s = 0;
    long e = 0;
    for(int i = 0; i < n; i++) {
      trees[i] = Long.parseLong(st.nextToken());
      e = Math.max(e, trees[i]);
    }

    long answer = 0;

    while(s <= e) {

      long mid = (s+e)/2;

      long result = 0;
      for(int i = 0; i < n; i++) {
        long tree = trees[i] - mid;
        if(tree < 0) {
          tree = 0;
        }
        result += tree;
      }

      if(result >= m) {
        s = mid + 1;
        answer = mid;
      }
      else {
        e = mid - 1;
      }
    }

    System.out.println(answer);




  }


}
