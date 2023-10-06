package baekjoon.backjoon10.day0110.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
우주 탐사선
https://www.acmicpc.net/problem/17182

모든 행성 탐사 걸리는 최소 시간

각 점에서 다른 점까지 가는 최소 거리를 구해 표로 저장한다.
DFS를 통해 순서를 정하고 최소 거리를 구한 표를 이용해 계산해 최소값을 구한다.

 */
public class B17182 {


    static int n; // 행성 갯수
    static int k; // 발사 위치
    static int[][] board;
    static int[][] dp;
    static boolean[] visited;
    static int[] selected;
    static int answer;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        Integer INF = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = INF;
                }
            }
        }


        for(int i = 0; i < n; i++) {
            shortDistance(i);
        }


        // 순서 정하기
        visited = new boolean[n];
        selected = new int[n];

        // 첫 번째 순서는 k로 정해져 있다.
        visited[k] = true;
        selected[0] = k;
        answer = INF;
        dfs(1);


        System.out.println(answer);

    }

    // 순서 정하기
    public static void dfs(int stage) {

        if(stage == n) {
            calculation();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                selected[stage] = i;
                dfs(stage+1);
                visited[i] = false;
            }
        }
    }

    // 순서에 따라 계산
    public static void calculation() {

        int start = selected[0];
        int end = 0;
        int result = 0;
        for(int i = 1; i < n; i++) {
            end = selected[i];
            result += dp[start][end];
            start = end;
        }

        answer = Math.min(answer, result);

    }



    // 정점에서 각 정점으로 가는 가장 짧은 거리 구하기
    public static void shortDistance(int start) {

        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            Integer d = que.poll();
            for(int i = 0; i < n; i++) {
                if(dp[start][i] > board[d][i] + dp[start][d]) {
                    dp[start][i] = board[d][i] + dp[start][d];
                    que.add(i);
                }
            }
        }

    }



}
