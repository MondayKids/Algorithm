package baekjoon.backjoon11.day0110.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
경쟁적 전염
https://www.acmicpc.net/problem/18405
 */
public class B18405 {

  static int n, k;
  static int[][] board;
  static int s, x, y;

  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,-1,0,1};


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    List<Queue<dot>> virus = new ArrayList<>();
    for(int i = 0; i <= k; i++) {
      virus.add(new LinkedList<>());
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] != 0) {
          int number = board[i][j];
          virus.get(number).add(new dot(i, j, 0));
        }
      }
    }

    for(int i = 0; i < s; i++) {
      for(int j = 0; j <= k; j++) {
        Queue<dot> que = virus.get(j);


        while(!que.isEmpty() && que.peek().count == i) {
          dot d = que.poll();
          for(int k = 0; k < 4; k++) {
            int ny = d.y + dy[k];
            int nx = d.x + dx[k];

            if (check(ny, nx)) {
              board[ny][nx] = j;
              que.add(new dot(ny, nx, d.count + 1));
            }
          }
        }
      }
    }

    System.out.println(board[y-1][x-1]);

  }



  public static boolean check(int y, int x) {
    if(y >= 0 && y < n && x >= 0 && x < n && board[y][x] == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  public static class dot {
    int y;
    int x;
    int count;

    dot(int y, int x, int count) {
      this.y = y;
      this.x = x;
      this.count = count;
    }
  }
}
