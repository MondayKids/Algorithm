package baekjoon.backjoon9.day16;

/*
예산
https://www.acmicpc.net/problem/2512
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2512 {

    static int n;
    static int[] board;
    static int m;


    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int big = 0;
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
            sum += board[i];
            big = Math.max(big, board[i]);
        }
        m = Integer.parseInt(br.readLine());



        int s = 0;
        int e = big;

        while(s <= e) {
            int mid = (s+e)/2;

            int result = 0;
            for(int i = 0; i < n; i++) {
                if(board[i] > mid) {
                    result += mid;
                }
                else {
                    result += board[i];
                }
            }

            if(result <= m) {
                s = mid + 1;
                answer = mid;
            }
            else {
                e = mid - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);

    }

}
