package baekjoon.backjoon12.day0110.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
마법사 상어와 비바라기
https://www.acmicpc.net/problem/21610


 */

public class B21610 {

  static int n, m;
  static int[][] board;

  static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
  static int[] dy = {0,0,-1,-1,-1,0,1,1,1};


  static List<cloud> clouds;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int d,s = 0;

    clouds = new ArrayList<>();
    clouds.add(new cloud(n-2,0));
    clouds.add(new cloud(n-2,1));
    clouds.add(new cloud(n-1,0));
    clouds.add(new cloud(n-1,1));

    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      d = Integer.parseInt(st.nextToken());
      s = Integer.parseInt(st.nextToken());

      // printCloud();
      cloudMove(d,s);
      rain();
      duplicatedBug();
      makeCloud();
    }

    int answer = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        answer += board[i][j];
      }
    }

    System.out.println(answer);


  }

  // 물의 양이 2 이상인 모든 칸에 구름 생성
  public static void makeCloud() {
    boolean[][] isCloud = new boolean[n][n];
    for(cloud c : clouds) {
      isCloud[c.y][c.x] = true;
    }
    clouds = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] >= 2 && !isCloud[i][j]) {
          clouds.add(new cloud(i, j));
          board[i][j] -= 2;
        }
      }
    }
  }


  // 비가 온 곳에 물복사 버그를 사용한다. 대각선에 물이 있으면 1씩 증가한다.
  public static void duplicatedBug() {
    for(cloud c : clouds) {
      for(int dir = 2; dir < 9; dir += 2) {
        int ny = c.y + dy[dir];
        int nx = c.x + dx[dir];

        if(check(ny,nx)) {
          board[c.y][c.x] += 1;
        }
      }
    }
  }

  // 범위 안에 있고 물이 있는지 확인
  public static boolean check(int y, int x) {
    if(y >= 0 && y < n && x >= 0 && x < n && board[y][x] > 0) {
      return true;
    }
    return false;
  }


  // 비가 내리고 구름은 사라진다.
  public static void rain() {
    for(cloud c : clouds) {
      board[c.y][c.x] += 1;
    }
  }

  // 구름 출력
  public static void printCloud() {
    System.out.println();
    for(cloud c : clouds) {
      System.out.println(c.y + " " + c.x);
    }
  }

  // 구름 이동
  public static void cloudMove(int d, int s) {
    for(cloud c : clouds) {
      c.y = move(0, c.y, d, s);
      c.x = move(1, c.x, d, s);
    }
  }

  // 구름 이동
  public static int move(int type, int location, int d, int s) {
    int dir = 0;
    if(type == 0) dir = dy[d];
    if(type == 1) dir = dx[d];

    s = s % n;

    int result = location + (dir * s);
    if(result < 0) {
      result = n + result;
    }
    else if(result > n-1) {
      result = result - n;
    }
    return result;
  }

  // 구름의 위치를 저장할 클래스
  public static class cloud {
    int y;
    int x;

    cloud(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}
