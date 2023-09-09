package baekjoon.backjoon9.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940 {

    static int n, m;
    static int[][] board;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        dot start = null;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 2) {
                    start = new dot(i, j, 0);
                }
            }
        }

        answer = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1) {
                    answer[i][j] = -1;
                }
                else if(board[i][j] == 0) {
                    answer[i][j] = 0;
                }
            }
        }

        Queue<dot> que = new LinkedList<>();

        answer[start.y][start.x] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            dot d = que.poll();

            for(int i = 0; i < 4; i++) {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if (check(ny, nx)) {
                    if(board[ny][nx] == 1 && answer[ny][nx] == -1) {
                        answer[ny][nx] = d.cost + 1;
                        que.add(new dot(ny, nx, d.cost + 1));
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    public static boolean check(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < m) {
            return true;
        }
        return false;
    }

    public static class dot {
        int y;
        int x;
        int cost;

        dot(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
