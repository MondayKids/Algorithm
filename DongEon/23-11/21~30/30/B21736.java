package baekjoon.backjoon11.day2130.day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21736 {

  static int n, m;
  static char[][] board;
  static boolean[][] visited;
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,-1,0,1};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new char[n][m];
    visited = new boolean[n][m];
    dot start = null;
    for(int i = 0; i < n; i++) {
      String s = br.readLine();
      for(int j = 0; j < m; j++) {
        board[i][j] = s.charAt(j);
        if(board[i][j] == 'I') {
          start = new dot(i, j);
          visited[i][j] = true;
        }
      }
    }

    Queue<dot> que = new LinkedList<>();
    que.add(start);
    int answer = 0;

    while (!que.isEmpty()) {
      dot d = que.poll();

      for(int i = 0; i < 4; i++) {
        int ny = d.y + dy[i];
        int nx = d.x + dx[i];

        if(check(ny,nx)) {
          visited[ny][nx] = true;
          if(board[ny][nx] == 'P') {
            answer += 1;
          }
          que.add(new dot(ny,nx));
        }
      }
    }

    if(answer == 0) {
      System.out.println("TT");
    }
    else {
      System.out.println(answer);
    }




  }

  public static boolean check(int y, int x) {
    if(y >= 0 && y < n && x >= 0 && x < m && visited[y][x] == false && board[y][x] != 'X') {
      return true;
    }
    return false;
  }

  public static class dot {
    int y;
    int x;

    dot(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}
