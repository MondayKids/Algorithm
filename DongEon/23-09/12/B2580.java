package baekjoon.backjoon9.day12;


/*
스도쿠
https://www.acmicpc.net/problem/2580
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2580 {

    static int[][] board;
    static List<dot> zeroList;
    static int n;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        zeroList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) {
                    zeroList.add(new dot(i, j));
                }
            }
        }

        n = zeroList.size();
        dfs(0);

    }

    public static void dfs(int stage) {

        if(flag) {
            return;
        }

        if (stage == n) {
            flag = true;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

            return;
        }



        dot d = zeroList.get(stage);
        for(int i = 1; i <= 9; i++) {
            if(check(d,i)) {
                board[d.y][d.x] = i;
                dfs(stage+1);
                board[d.y][d.x] = 0;
            }
        }
    }

    public static boolean check(dot d, int num) {
        // 세로,가로 체크
        for(int i = 0; i < 9; i++) {
            if(board[d.y][i] == num) {
                return false;
            }
            if(board[i][d.x] == num) {
                return false;
            }
        }


        // 3 X 3 정사각형 체크
        int sy = convert(d.y);
        int sx = convert(d.x);

        for(int i = sy; i < sy + 3; i++) {
            for(int j = sx; j < sx + 3; j++) {
                if(board[i][j] == num) {
                    return false;
                }
            }
        }


        return true;

    }

    public static int convert(int num) {
        int result = num / 3;
        return result * 3;
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
