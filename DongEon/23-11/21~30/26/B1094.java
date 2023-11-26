package baekjoon.backjoon11.day2130.day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
막대기
https://www.acmicpc.net/problem/1094
 */
public class B1094 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String binaryString = Integer.toBinaryString(n);

    long count = binaryString.chars()
            .filter(c -> c == '1')
            .count();

    System.out.println(count);


  }

}
