package baekjoon;


/*

https://www.acmicpc.net/problem/2630
색종이 만들기

하연색 색종이, 파란색 색종이 구하기
같은 작업이 반복되기 때문에 DFS를 사용한다.

DFS
입력값 : 시작 위치, 변의 길이
로직 :

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {

    static int n;
    static int[][] board;

    static int white;
    static int blue;

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

        // 탐색 시작
        dfs(0, 0, n);

        // 출력부
        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);


    }

    public static void dfs(int startY, int startX, int len) {



        // 이 구역이 동일한 색상인지 확인
        int color = board[startY][startX];
        boolean check = false;

        // 모든 구역이 동일한 색상인지 확인
        // 색상이 다르면 다시 4개로 쪼개서 dfs로 돌림
        for(int i = startY; i < startY + len; i++) {
            for(int j = startX; j < startX + len; j++) {
                if(color != board[i][j]) {
                    check = true;
                    break;
                }
            }
        }

        // 이 구역이 모두 동일한 색상
        if(check == false) {
            if(color == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        if(check == true) {
            dfs(startY, startX, len/2);
            dfs(startY, startX + len/2, len/2);
            dfs(startY + len/2, startX, len/2);
            dfs(startY + len/2, startX + len/2, len/2);
        }
    }




}
