package baekjoon.backjoon10.day1120.day12;

/*
경로 찾기
https://www.acmicpc.net/problem/11403
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11403 {

    static int n;
    static int[][] board;
    static int[][] answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st = null;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[n][n];

        for(int i = 0; i < n; i++) {
            search(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void search(int start) {
        visited = new boolean[n+1];

        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            Integer dot = que.poll();

            for(int i = 0; i < n; i++) {
                if(board[dot][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    answer[start][i] = 1;
                    que.add(i);
                }
            }
        }


    }

}
