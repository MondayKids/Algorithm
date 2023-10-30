package baekjoon.backjoon10.day2131.day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
체스판 다시 칠하기2
https://www.acmicpc.net/problem/25682

왼쪽 위가 흰색일 때, 검은색 일 때 각각의 prefix를 구한다.
 */
public class B25682 {

  static int n,m,k;
  static int[][] board;

  static int[][] blackBoard;
  static int[][] whiteBoard;

  static int[][] prefixBlackBoard;
  static int[][] prefixWhiteBoard;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new int[n][m];

    for(int i = 0; i < n; i++) {
      String s = br.readLine();
      for(int j = 0; j < m; j++) {
        if(s.charAt(j) == 'B') {
          board[i][j] = 1;
        }
        else {
          board[i][j] = 0;
        }
      }
    }

    blackBoard = new int[n+1][m+1];
    whiteBoard = new int[n+1][m+1];

    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j < m+1; j++) {

        if( (i-1+j-1) % 2 == 0) {
          if(board[i-1][j-1] == 0) {
            blackBoard[i][j] = 1;
          }
          else if(board[i-1][j-1] == 1) {
            whiteBoard[i][j] = 1;
          }
        }

        if( (i-1+j-1)%2 == 1) {
          if(board[i-1][j-1] == 1) {
            blackBoard[i][j] = 1;
          }
          else if(board[i-1][j-1] == 0) {
            whiteBoard[i][j] = 1;
          }
        }
      }
    }


    prefixBlackBoard = new int[n+1][m+1];
    prefixWhiteBoard = new int[n+1][m+1];


    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j < m+1; j++) {
       prefixBlackBoard[i][j] = blackBoard[i][j] + prefixBlackBoard[i-1][j] + prefixBlackBoard[i][j-1] - prefixBlackBoard[i-1][j-1];
       prefixWhiteBoard[i][j] = whiteBoard[i][j] + prefixWhiteBoard[i-1][j] + prefixWhiteBoard[i][j-1] - prefixWhiteBoard[i-1][j-1];
      }
    }

    int answer = m*n;

    for(int i = k; i < n+1; i++) {
      for(int j = k; j < m+1; j++) {
        int blackResult = prefixBlackBoard[i][j] - prefixBlackBoard[i-k][j] - prefixBlackBoard[i][j-k] + prefixBlackBoard[i-k][j-k];
        int whiteResult = prefixWhiteBoard[i][j] - prefixWhiteBoard[i-k][j] - prefixWhiteBoard[i][j-k] + prefixWhiteBoard[i-k][j-k];

        answer = Math.min(answer, blackResult);
        answer = Math.min(answer, whiteResult);

      }
    }

    System.out.println(answer);

  }

  public static void printBoard() {
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void printBlackBoard() {
    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j < n+1; j++) {
        System.out.print(blackBoard[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void printWhiteBoard() {
    for(int i = 1; i < n+1; i++) {
      for(int j = 1; j < n+1; j++) {
        System.out.print(whiteBoard[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

}
