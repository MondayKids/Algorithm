package baekjoon.backjoon9.day27;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
레이저 통신
https://www.acmicpc.net/problem/6087
 */

public class B6087 {

    static int w,h;
    static char[][] board;
    static int[] start;
    static int[] end;

    static int[][][] dp;
    static int INF = Integer.MAX_VALUE;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new char[h][w];
        start = new int[2];
        end = new int[2];
        boolean flag = false;

        for(int i = 0; i < h; i++) {
            String str = br.readLine();
            for(int j = 0; j < w; j++) {
                board[i][j] = str.charAt(j);

                if(board[i][j] == 'C') {
                    if(flag == false) {
                        start[0] = i;
                        start[1] = j;
                        flag = true;
                    }
                    else {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
        }

        dp = new int[h][w][4];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        Queue<dot> que = new LinkedList<>();
        for(int i = 0; i < 4; i++) {
            que.add(new dot(start[0], start[1], i, 0));
            dp[start[0]][start[1]][i] = 0;
        }



        while (!que.isEmpty()) {

            dot d = que.poll();

            for(int i = 0; i < 4; i++) {

                // 뒤로 쏘는 방향은 없다
                if(Math.abs(d.dir - i) == 2) {
                    continue;
                }

                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(check(ny,nx)) {

                    int newCount = d.count;

                    // 거울을 설치할 경우
                    if(Math.abs(d.dir - i) == 1 || Math.abs(d.dir - i) == 3) {
                        newCount += 1;
                    }

                    if(dp[ny][nx][i] > newCount) {
                        dp[ny][nx][i] = newCount;
                        que.add(new dot(ny, nx, i, newCount));
                    }

                }
            }
        }

        int answer = INF;
        for(int i = 0; i < 4; i++) {
            answer = Math.min(answer, dp[end[0]][end[1]][i]);
        }
        System.out.println(answer);



    }

    public static boolean check(int y, int x) {
        if(y >= 0 && y < h && x >= 0 && x < w && board[y][x] != '*') {
            return true;
        }
        else {
            return false;
        }
    }

    public static class dot {
        int y;
        int x;
        int dir;
        int count;

        dot(int y, int x, int dir, int count) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.count = count;
        }
    }















}
