package baekjoon.year24.month1.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
문자열 판별
https://www.acmicpc.net/problem/16500

역순으로 판별한다.
역순으로 단어를 잘라서 포함되면 1
탐색 시작 위치에서 잘린 위치까지 단어가 있으면 1, 없으면 0
 */
public class B16500 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String target = br.readLine();
    int n = Integer.parseInt(br.readLine());

    Set<String> words = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      words.add(word);
    }

    int[] dp = new int[target.length()];

    for (int i = target.length() - 1; i >= 0; i--) {
      for (int j = i + 1; j < target.length(); j++) {

        if(dp[j] == 1 && words.contains(target.substring(i, j))) {
          dp[i] = 1;
        }

        if (words.contains(target.substring(i))) {
          dp[i] = 1;
        }

      }





    }

    System.out.println(dp[0]);

  }

}
