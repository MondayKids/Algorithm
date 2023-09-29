package baekjoon.backjoon9.day29;

/*
소문난 칠공주
https://www.acmicpc.net/problem/1941

Y : 임도연파
S : 이다솜파


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class B1941 {

    static int n;
    static int[][] board;

    static int[] select; // 7개 선택
    static boolean[][] selectBoard;
    static boolean[][] visited; // 7개가 연결되어 있는지 확인

    static int one; // 선택된 것 중 이다솜파의 갯수
    static int zero; // 선택된 것 중 임도연파의 갯수

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static int answer;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = 5;
        board = new int[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                if(str.charAt(j) == 'Y') {
                    board[i][j] = 0;
                }
                else {
                    board[i][j] = 1;
                }
            }
        }

        select = new int[7];
        selectBoard = new boolean[5][5];
        visited = new boolean[5][5];
        answer = 0;
        dfs(0, 0);

        System.out.println(answer);


    }


    // 25개의 칸 중 7개 선택
    public static void dfs(int stage, int number) {

        if(zero == 4) {
            return;
        }

        if(stage == 7) {
            answerCheck();
            return;
        }

        for(int i = number; i < 25; i++) {

            int y = i / 5;
            int x = i % 5;

            if(board[y][x] == 1) {
                one++;
            }
            else {
                zero++;
            }


            select[stage] = i;
            selectBoard[y][x] = true;
            dfs(stage+1, i+1);

            if(board[y][x] == 1) {
                one--;
            }
            else {
                zero--;
            }
            selectBoard[y][x] = false;
        }
    }


    // 상하좌우 인접해 있는지 확인
    public static void answerCheck() {

        visited = new boolean[n][n];

        int starty = select[0] / 5;
        int startx = select[0] % 5;



        Queue<dot> que = new LinkedList<>();
        que.add(new dot(starty, startx));

        visited[starty][startx] = true;
        int count = 1;

        while (!que.isEmpty()) {
            dot d = que.poll();

            for(int i = 0; i < 4; i++) {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(check(ny,nx)) {
                    visited[ny][nx] = true;
                    count++;
                    que.add(new dot(ny,nx));
                }
            }
        }

        if(count == 7) {
            answer++;
        }
    }

    public static boolean check(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < n && selectBoard[y][x] == true && visited[y][x] == false) {
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
