package baekjoon;

/*
숨바꼭질3
https://www.acmicpc.net/problem/13549


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13549 {

    static int n;
    static int k;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[100001];
        Arrays.fill(board, -1);

        Queue<dot> que = new LinkedList<>();
        que.add(new dot(n, 0));
        int count = 0;
        board[n] = 0;
        while (!que.isEmpty()) {
            dot d = que.poll();

            int plus = d.location + 1;
            int minus = d.location - 1;
            int teleport = d.location * 2;

            if(teleport <= 100000 && (board[teleport] == -1 || board[teleport] > d.count)) {
                board[teleport] = d.count ;
                que.add(new dot(teleport, d.count));
            }

            if(plus <= 100000 && (board[plus] == -1 || board[plus] > d.count+1) ) {
                board[plus] = d.count+1;
                que.add(new dot(plus, d.count + 1));
            }
            if(minus >= 0 && (board[minus] == -1 || board[minus] > d.count+1)) {
                board[minus] = d.count+1;
                que.add(new dot(minus, d.count + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(board[k]);
        System.out.println(sb);

    }

    public static class dot {
        int location;
        int count;

        dot(int location, int count) {
            this.location = location;
            this.count = count;
        }
    }


}
