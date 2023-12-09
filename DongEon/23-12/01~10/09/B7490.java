package baekjoon.backjoon12.day0110.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
0 만들기
https://www.acmicpc.net/problem/7490
 */
public class B7490 {

  static int t;
  static int n;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());
    while(t-- > 0) {
      n = Integer.parseInt(br.readLine());
      dfs(2, "1");
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void dfs(int stage, String formula) {


    if(stage == n+1) {
      if(calculation(formula)) {
        sb.append(formula).append("\n");
      }
      return;
    }

    dfs(stage+1, formula + " " + stage);
    dfs(stage+1, formula + "+" + stage);
    dfs(stage+1, formula + "-" + stage);
  }

  public static boolean calculation(String formula) {
    // 공백 제거
    String nonBlank = formula.replace(" ", "");

    int result = 0;
    char opr = '+';
    String number = "";

    for(int i = 0; i < nonBlank.length(); i++) {
      char c = nonBlank.charAt(i);

      if(Character.isDigit(c)) {
        number += c;
      }

      if(c == '+' || c == '-' || i == nonBlank.length() - 1) {
        int after = Integer.parseInt(number);
        if(opr == '+') result += after;
        else if(opr == '-') result -= after;
        opr = c;
        number = "";
      }
    }
    return result == 0;
  }

}
