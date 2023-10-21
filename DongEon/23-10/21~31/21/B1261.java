package baekjoon.backjoon10.day2131.day21;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
알고스팟
https://www.acmicpc.net/problem/1261
 */
public class B1261 {

    static int n,m;
    static int[][] board;
    static int[][] dp;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                int number = Character.getNumericValue(str.charAt(j));
                board[i][j] = number;
            }
        }

        dp = new int[n][m];
        int large = n*m+1;
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], large);
        }

        Queue<dot> que = new LinkedList<>();
        dp[0][0] = 0;
        que.add(new dot(0, 0, 0));

        while (!que.isEmpty()) {
            dot d = que.poll();

            for(int i = 0; i < 4; i++) {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(check(ny, nx)) {
                    int newCount = d.count;
                    if(board[ny][nx] == 1) {
                        newCount += 1;
                    }

                    if(dp[ny][nx] > newCount) {
                        dp[ny][nx] = newCount;
                        que.add(new dot(ny, nx, newCount));
                    }
                }
            }
        }

        System.out.println(dp[n-1][m-1]);

    }

    public static boolean check(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < m) {
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
