package baekjoon.backjoon11.day1120.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
숫자고르기
https://www.acmicpc.net/problem/2668
 */
public class B2668 {

  static int n;
  static int[] board;

  static boolean[] visited; // 방문 여부 확인
  static boolean[] finished; // 탐색 완료

  static List<Integer> answer;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      board[i] = Integer.parseInt(br.readLine());
    }

    // 사이클이 완성되면 정답 후보다
    answer = new ArrayList<>();

    visited = new boolean[n + 1];
    finished = new boolean[n + 1];


    for (int i = 1; i < n + 1; i++) {
      if(finished[i] == false) {
        search(i);
      }
    }

    Collections.sort(answer);

    System.out.println(answer.size());
    for (int number : answer) {
      System.out.println(number);
    }

  }

  public static void search(int number) {

    // 이미 탐색이 완료되었다면 종료
    if(finished[number] == true) {
      return;
    }

    // 이미 방문해본적이 있다면 사이클이므로 정답에 추가
    if(visited[number]) {
      finished[number] = true;
      answer.add(number);
    }

    // 방문 여부를 체크하고 탐색 진행
    visited[number] = true;
    search(board[number]);

    // 탐색을 마쳤다면 탐색 완료에 체크
    visited[number] = false;
    finished[number] = true;

  }




}
