package baekjoon.backjoon10.day1120.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
https://www.acmicpc.net/problem/1743
음식물 피하기
 */

public class B1743 {

    static int n, m, k;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            board[y][x] = true;
        }

        visited = new boolean[n][m];
        answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] && visited[i][j] == false) {
                    search(i, j);
                }
            }
        }

        System.out.println(answer);


    }

    public static void search(int y, int x) {


        visited[y][x] = true;
        int result = 1;

        Queue<dot> que = new LinkedList<>();
        que.add(new dot(y,x));

        while (!que.isEmpty()) {
            dot d = que.poll();

            for(int i = 0; i < 4; i++) {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(check(ny,nx)) {
                    que.add(new dot(ny,nx));
                    visited[ny][nx] = true;
                    result++;
                }

            }

        }

        answer = Math.max(answer, result);

    }

    public static boolean check(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < m && board[y][x] == true && visited[y][x] == false){
            return true;
        }
        else {
            return false;
        }
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
