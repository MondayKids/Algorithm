package baekjoon.backjoon12.day0110.day08;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
순열의 순서
https://www.acmicpc.net/problem/1722

20! 이라 일일이 구하면 시간 초과가 발생한다.

참고 사이트
https://dundung.tistory.com/60
 */
public class B1722 {

  static int n;
  static int type;

  static long[] factorial;
  static boolean[] check;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    type = Integer.parseInt(st.nextToken());

    factorial = new long[n+1];
    makeFactorial(n);
    check = new boolean[n+1];

    if(type == 1) {
      long index = Long.parseLong(st.nextToken());
      one(index);
    }
    else if(type == 2) {
      int[] numbers = new int[n];
      for(int i = 0; i < n; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }
      two(numbers);
    }
  }

  // 몇 번째인지 주어지고 순열이 뭔지 구해야한다.
  public static void one(long index) {

    int[] numbers = new int[n];

    for(int i = 0; i < n; i++) {
      for(int j = 1; j <= n; j++) {

        // 이미 사용되었으면 넘어간다.
        if(check[j]) continue;

        // 이 자리의 숫자가 들어갈 수 있다면 뺀다.
        if(factorial[n-i-1] < index) {
          index -= factorial[n-i-1];
        }
        else {
          numbers[i] = j;
          check[j] = true;
          break;
        }
      }
    }
    for(int i = 0; i < n; i++) {
      System.out.print(numbers[i] + " ");
    }
  }

  // 순열이 주어지고 몇 번째 인지 구해야 함
  public static void two(int[] numbers) {
    long index = 1;
    for(int i = 0; i < n; i++) {
      for(int j = 1; j < numbers[i]; j++) {
        if(check[j] == false) {
          index += factorial[n-i-1];
        }
      }
      check[numbers[i]] = true;
    }
    System.out.println(index);
  }

  public static void makeFactorial(int n) {
    factorial[0] = 1;
    for(int i = 1; i <= n; i++) {
      factorial[i] = factorial[i-1] * i;
    }
  }





}
