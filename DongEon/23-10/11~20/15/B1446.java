package baekjoon.backjoon10.day1120.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1446 {

    static int n;
    static int d;
    static int[][] board;
    static int answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        board = new int[n][3];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board, (o1, o2) -> o1[0] - o2[0]);

        answer = 10_000;
        dfs(0,0,0);
        System.out.println(answer);

    }

    // 단계, 현재 위치, 거리
    public static void dfs(int stage, int now, int distance) {

        if(stage == n) {
            int newDistance = distance + (d - now);
            answer = Math.min(answer, newDistance);
            return;
        }

        // 지름길을 이용하는 경우
        if(board[stage][0] >= now && board[stage][1] <= d) {
            int newDistance = distance + (board[stage][0] - now) + board[stage][2];
            dfs(stage+1, board[stage][1], newDistance);
        }

        // 지름길을 이용하지 않는 경우
        dfs(stage + 1, now, distance);

    }



}
