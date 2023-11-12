package baekjoon.backjoon11.day1120.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
돌 게임2
https://www.acmicpc.net/problem/9656

상근 -> 창영

1 : 상근
2 : 창영
3 : 상근
4 : 창영
5 : 상근

f(n-1) 하나를 뽑는 경우의 수
f(n-3) 하나를 뽑는 경우의 수



 */
public class B9656 {

  static int n;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    if(n % 2 == 0) {
      System.out.println("SK");
    }
    else {
      System.out.println("CY");
    }






  }
}
