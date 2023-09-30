package baekjoon.backjoon9.day30;

/*
비숍
https://www.acmicpc.net/problem/1799

1 : 비숍을 놓을 수 있는 위치
0 : 비숍을 놓을 수 없는 위치

비숍을 놓았을 때 비숍의 영역을 색칠하는게 아니라
비숍을 놓는다고 가정했을 때 경로에 비숍에 없는지를 체크

3
0 1 1
1 1 1
1 1 1

ans:4

5
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1

ans:8

8
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1

ans : 14

10
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1

ans:18


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1799 {

    static int n;
    static int[][] board;
    static int[][] chess;

    static boolean[][] visited;

    static int black;
    static int white;

    static int answer;

    // 대각선  우하, 좌하, 좌상, 우상
    static int[] dx = {1, -1, -1, 1};
    static int[] dy = {1, 1, -1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        chess = new int[n][n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                chess[i][j] = (i+j) % 2;
            }
        }

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.print(chess[i][j] + " ");
//            }
//            System.out.println();
//        }



        black = 0;
        white = 0;

        // black 탐색
        dfs(0, 0, chess[0][0], 0);

        // white 탐색
        dfs(0, 1, chess[0][1], 0);

        answer = black + white;

        System.out.println(answer);

    }

    public static void dfs(int y, int x, int color ,int count) {



        if(y >= n) {
            if(color == 0) {
                black = Math.max(black, count);
            }
            else {
                white = Math.max(white, count);
            }
            return;
        }

        int nx = x + 2;
        int ny = y;

        if(nx >= n) {
            ny++;
            if(ny < n) {
                if(chess[ny][0] == color) {
                    nx = 0;
                }
                else {
                    nx = 1;
                }
            }
        }



        // 둘 수 없는 경우 넘어간다.
        if(board[y][x] == 0) {
            dfs(ny, nx, color, count);
            return;
        }

        // 현재 장소에 비숍을 둘 수 있을 때 비숍을 두는 경우
        if(bishop(y,x)) {
            visited[y][x] = true;
            dfs(ny, nx, color, count+1);
            visited[y][x] = false;
        }

        // 비숍을 두지 않고 그냥 넘어가는 경우
        dfs(ny, nx, color, count);

    }

    // y,x에 비숍을 두었을 때 경로에 다른 비숍이 있는지 확인
    public static boolean bishop(int y, int x) {

        // 대각선 4방향 표시
        for(int i = 0; i < 4; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            while(check(ny,nx)) {

                if(visited[ny][nx] == true) {
                    return false;
                }

                ny += dy[i];
                nx += dx[i];
            }

        }
        return true;
    }

    public static boolean check(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < n) {
            return true;
        }
        else {
            return false;
        }
    }


}
