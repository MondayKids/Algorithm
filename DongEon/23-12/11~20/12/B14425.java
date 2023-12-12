package baekjoon.backjoon12.day1120.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
문자열 집합
https://www.acmicpc.net/problem/14425
 */

public class B14425 {

  static int n, m;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    List<String> words = new ArrayList<>();
    while(n-- > 0) {
      words.add(br.readLine());
    }

    int answer = 0;
    while(m-- > 0) {
      String input = br.readLine();
      for(String word : words) {
        if(word.equals(input)) {
          answer += 1;
          break;
        }
      }
    }

    System.out.println(answer);


  }

}
