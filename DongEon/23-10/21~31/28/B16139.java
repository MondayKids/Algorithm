package baekjoon.backjoon10.day2131.day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
인간-컴퓨터 상호작용
https://www.acmicpc.net/problem/16139
 */


public class B16139 {

  static String s;
  static int q;
  static char a;
  static int l,r;


  static int[][] prefix;

  static StringBuilder sb;
  static List<Integer> answer;



  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
    q = Integer.parseInt(br.readLine());

    int n = s.length();
    prefix = new int[26][n+1];

    for(int i = 1; i < n+1; i++) {

      for(int j = 0; j < 26; j++) {
        prefix[j][i] = prefix[j][i-1];
      }

      int number = (int) (s.charAt(i-1) - 'a');
      prefix[number][i] += 1;
    }

    answer = new ArrayList<>();

    for(int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      a = st.nextToken().charAt(0);
      l = Integer.parseInt(st.nextToken())+1;
      r = Integer.parseInt(st.nextToken())+1;
      simulation();
    }

    sb = new StringBuilder();

    for(int i = 0; i < answer.size()-1; i++) {
      sb.append(answer.get(i)).append("\n");
    }
    sb.append(answer.get(answer.size()-1));

    System.out.println(sb);

  }

  public static void simulation() {
    int number = (int)(a - 'a');
    int result = prefix[number][r] - prefix[number][l-1];
    answer.add(result);
  }

}
