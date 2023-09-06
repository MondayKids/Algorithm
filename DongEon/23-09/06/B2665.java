package baekjoon.backjoon9.day06;


/*
미로만들기
https://www.acmicpc.net/problem/2665
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2665 {

    static int n;
    static int[][] board;

    static int[][] count;
    static int INF = 987654321;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = (int) (s.charAt(j) - '0');
            }
        }

        count = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(count[i], INF);
        }


        count[0][0] = 0;
        PriorityQueue<dot> pq = new PriorityQueue<>();
        pq.add(new dot(0, 0, 0));

        while (!pq.isEmpty()) {
            dot d = pq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if (checkBoard(ny, nx)) {
                    // 벽을 만난 경우
                    if(board[ny][nx] == 0) {
                        if(count[ny][nx] > d.cost + 1) {
                            count[ny][nx] = d.cost + 1;
                            pq.add(new dot(ny, nx, d.cost + 1));
                        }
                    }
                    else if(board[ny][nx] == 1) {
                        if(count[ny][nx] > d.cost) {
                            count[ny][nx] = d.cost;
                            pq.add(new dot(ny, nx, d.cost));
                        }
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(count[n-1][n-1]);
        System.out.println(sb);


    }

    public static boolean checkBoard(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < n) {
            return true;
        }
        return false;
    }

    // dot의 cost는 지나온 검을 길을 의미한다.
    static class dot implements Comparable<dot> {
        int y;
        int x;
        int cost;

        dot(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        public int compareTo(dot d) {
            return this.cost - d.cost;
        }
    }

}
