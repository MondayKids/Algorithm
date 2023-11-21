package baekjoon.backjoon11.day2130.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
완전 이진 트리
https://www.acmicpc.net/problem/9934
 */

public class B9934 {

  static int k; // 깊이
  static int n;
  static int[] number;
  static List<Integer>[] answer;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());
    n = (int) Math.pow(2,k) - 1;
    number = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      number[i] = Integer.parseInt(st.nextToken());
    }

    answer = new List[k];
    for(int i = 0; i < k; i++) {
      answer[i] = new ArrayList<>();
    }

    search(0, n-1, 0);

    for(int i = 0; i < k; i++) {
      for(int data : answer[i]) {
        System.out.print(data + " ");
      }
      System.out.println();
    }

  }

  public static void search(int s, int e, int depth) {

    if(depth == k) {
      return;
    }

    int mid = (s+e)/2;
    answer[depth].add(number[mid]);

    search(s, mid - 1, depth+1);
    search(mid + 1, e, depth+1);

  }









}
