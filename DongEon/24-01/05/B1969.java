package baekjoon.year24.month1.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
DNA
https://www.acmicpc.net/problem/1969

ACGT

 */
public class B1969 {

  static int n;
  static int m;
  static int[][] dnas;

  static int result;
  static StringBuilder answer;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    dnas = new int[m][4];
    for (int i = 0; i < n; i++) {
      String dna = br.readLine();

      for(int j = 0; j < m; j++) {
        countDna(j, dna.charAt(j));
      }
    }

    answer = new StringBuilder();

    for(int i = 0; i < m; i++) {

      int small = 0;

      for(int j = 1; j < 4; j++) {
        if(dnas[i][small] > dnas[i][j]) {
          small = j;
        }
      }

      result += dnas[i][small];

      if(small == 0) answer.append("A");
      if(small == 1) answer.append("C");
      if(small == 2) answer.append("G");
      if(small == 3) answer.append("T");

    }

    System.out.println(answer);
    System.out.println(result);




  }



  public static void countDna(int j, char c) {
    int location = 0;

    if(c == 'A') location = 0;
    if(c == 'C') location = 1;
    if(c == 'G') location = 2;
    if(c == 'T') location = 3;

    for(int i = 0; i < 4; i++) {
      if(location != i) dnas[j][i] += 1;
    }

  }



}
