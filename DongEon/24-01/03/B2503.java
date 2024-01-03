package baekjoon.year24.month1.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
숫자 야구
https://www.acmicpc.net/problem/2503

모든 경우의 수를 푼다.
 */

public class B2503 {

  static int n;
  static List<answer> answers;

  static int result;
  static int[] numbers;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    answers = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String number = st.nextToken();
      int strike = Integer.parseInt(st.nextToken());
      int ball = Integer.parseInt(st.nextToken());

      answers.add(new answer(number, strike, ball));
    }

    result = 0;
    numbers = new int[3];
    visited = new boolean[10];

    dfs(0);

    System.out.println(result);
  }

  // 모든 숫자 탐색
  public static void dfs(int stage) {

    if(stage == 3) {
      check();
      return;
    }

    for(int i = 1; i <= 9; i++) {
      if(visited[i] == false) {
        visited[i] = true;
        numbers[stage] = i;
        dfs(stage+1);
        visited[i] = false;
      }
    }
  }

  // 경우의 수가 정답을 충족하는지 확인
  public static void check() {

    for(answer a : answers) {
      int strike = 0;
      int ball = 0;

      String number = a.number;
      for(int i = 0; i < 3; i++) {

        for(int j = 0; j < 3; j++) {
          int numberOne = (int)(number.charAt(j) - '0');

          if(numbers[i] == numberOne) {
            if(i == j) {
              strike++;
            }
            else {
              ball++;
            }
          }
        }
      }

      if(strike != a.strike || ball != a.ball) {
        return;
      }
    }

    result++;

  }




  // 영수의 대답
  public static class answer {

    String number;
    int strike;
    int ball;

    answer(String number, int strike, int ball) {
      this.number = number;
      this.strike = strike;
      this.ball = ball;
    }
  }

}
