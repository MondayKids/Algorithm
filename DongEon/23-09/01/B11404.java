package baekjoon.backjoon9;

/*
23.09.01
플로이드
https://www.acmicpc.net/problem/11404


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11404 {

    static int n;
    static int m;
    static int[][] board;
    static int[][] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        board = new int[n][n];

        StringTokenizer st = null;
        int a, b, c = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken());

            if(board[a][b] == 0) {
                board[a][b] = c;
            }
            else if(board[a][b] > c) {
                board[a][b] = c;
            }
        }

        answer = new int[n][n];


        for(int i = 0; i < n; i++) {
            search(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void search(int start) {

        Queue<dot> que = new LinkedList<>();
        que.add(new dot(start, 0));

        while (!que.isEmpty()) {
            dot d = que.poll();

            for(int i = 0; i < n; i++) {

                if(i == start) {
                    continue;
                }

                int cost = board[d.start][i];
                if(cost != 0) {
                    if(answer[start][i] == 0) {
                        answer[start][i] = d.cost + cost;
                        que.add(new dot(i, d.cost + cost));
                    }
                    else if(answer[start][i] > d.cost + cost) {
                        answer[start][i] = d.cost + cost;
                        que.add(new dot(i, d.cost + cost));
                    }
                }

            }

        }

    }

    public static class dot {
        int start;
        int cost;

        dot(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
    }
}
