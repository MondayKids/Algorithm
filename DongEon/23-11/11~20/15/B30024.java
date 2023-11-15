package baekjoon.backjoon11.day1120.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
옥수수밭
https://www.acmicpc.net/problem/30024
 */
public class B30024 {

  static int n, m;
  static int[][] board;
  static int k;
  static PriorityQueue<dot> pq;
  static boolean[][] visited;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};
  static StringBuilder sb;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    visited = new boolean[n][m];

    pq = new PriorityQueue<>();

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if(i == 0 || j == 0 || i == n-1 || j == m-1) {
          pq.add(new dot(i, j, board[i][j]));
          visited[i][j] = true;
        }
      }
    }
    k = Integer.parseInt(br.readLine());



    sb = new StringBuilder();
    for(int i = 0; i < k; i++) {
      harvesting();
    }

    System.out.println(sb.toString());

  }

  public static void harvesting() {
    dot d = pq.poll();
    sb.append(d.y+1).append(" ").append(d.x+1).append("\n");

    for(int i = 0; i < 4; i++) {
      int ny = d.y + dy[i];
      int nx = d.x + dx[i];

      if(check(ny,nx)){
        visited[ny][nx] = true;
        pq.add(new dot(ny, nx, board[ny][nx]));
      }
    }
  }

  public static boolean check(int y, int x) {
    if(y >= 0 && y < n && x >= 0 && x < m && !visited[y][x]) {
      return true;
    }
    else {
      return false;
    }
  }

  public static class dot implements Comparable<dot> {
    int y;
    int x;
    int number;

    dot(int y, int x, int number) {
      this.y = y;
      this.x = x;
      this.number = number;
    }


    @Override
    public int compareTo(dot d) {
      return d.number - this.number;
    }
  }

}
