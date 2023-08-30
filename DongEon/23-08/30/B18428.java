package baekjoon;

/*
감시 피하기
https://www.acmicpc.net/problem/18428

장애물 3개 그리디로 위치 놓음
각각의 경우마다 감시 프로그램을 돌려 들키는지 안들키는지 확인

 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class B18428 {

    static int n;
    static char[][] board;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static List<dot> teacherList;
    static boolean answer;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        StringTokenizer st = null;
        teacherList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if(board[i][j] == 'T') {
                    teacherList.add(new dot(i, j));
                }
            }
        }

        answer = false;

        dfs(0,0,0);

        StringBuilder sb = new StringBuilder();
        if(answer == false) {
            sb.append("NO");
        }
        else {
            sb.append("YES");
        }

        System.out.println(sb);


    }


    public static void dfs(int stage, int y, int x) {

        if(answer || y >= n) {
            return;
        }

        if(stage == 3) {
            checkBoard();
            return;
        }

        int nx = x+1;
        int ny = y;
        if(nx >= n) {
            nx = 0;
            ny = y+1;
        }


        if(board[y][x] == 'X') {
            board[y][x] = 'O';
            dfs(stage+1, ny, nx);
            board[y][x] = 'X';
        }
        dfs(stage, ny, nx);

    }

    // 모든 학생들이 감시로부터 피할 수 있는지 확인
    // false : 학생 감시 걸림, true 학생 감시 안 걸림
    public static void checkBoard() {
        for(dot data : teacherList) {
            for(int i = 0; i < 4; i++) {
                if(!oneSight(data.y, data.x, i)) {
                    return;
                }
            }
        }
        answer = true;
    }


    // 한 줄 감시
    // false : 학생 만남, true : 학생 안만남
    public static boolean oneSight(int y, int x, int dir) {
        int ny = y + dy[dir];
        int nx = x + dx[dir];

        while(check(ny, nx)) {
            if(board[ny][nx] == 'O') {
                return true;
            }
            else if(board[ny][nx] == 'S') {
                return false;
            }
            ny += dy[dir];
            nx += dx[dir];
        }
        return true;
    }

    // board 안에 있는지 확인
    // false : 더 이상 못감, true : 계속 감
    public static boolean check(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < n) {
            return true;
        }
        return false;
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
