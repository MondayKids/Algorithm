package baekjoon.backjoon10.day0110.day05;



/*
야구
https://www.acmicpc.net/problem/17281

9명의 타순 순서
8명의 타순만 정하면 된다.
타순을 정한 다음 Simulation을 실행한다.

1번 선수는 4번 타자로 고정
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17281 {

    static int n;
    static int[][] board;
    static int[] select;
    static boolean[] visited;
    static int result;
    static boolean[] field;


    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][9];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        select = new int[9];
        visited = new boolean[9];
        dfs(0);

        System.out.println(answer);

    }

    public static void dfs(int stage) {
        if(stage == 9) {
            simulation();
            return;
        }

        if(stage == 3) {
            select[stage] = 0;
            dfs(stage+1);
        }

        for(int i = 1; i < 9; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                select[stage] = i;
                dfs(stage+1);
                visited[i] = false;
            }
        }
    }

    public static void simulation() {

        result = 0;
        int now = 0; // 타자 순번


        // 이닝
        for(int i = 0; i < n; i++) {
            int out = 0;
            field = new boolean[4];

            while(out < 3) {
                int player = select[now];
                // 아웃
                int data = board[i][player];
                if(data == 0) {
                    out++;
                }
                else {
                    anta(data);
                }

                now++;
                if(now == 9) {
                    now = 0;
                }
            }
        }

        answer = Math.max(answer, result);

    }

    public static void anta(int number) {
        field[0] = true;
        for(int i = 3; i >= 0; i--) {
            if(field[i] == true) {
                field[i] = false;
                int num = i + number;
                if(num > 3) {
                    result++;
                }
                else {
                    field[num] = true;
                }
            }
        }
    }

}
