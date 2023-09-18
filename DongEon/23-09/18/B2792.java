package baekjoon.backjoon9.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
보석 상자
https://www.acmicpc.net/problem/2792

같은 색상의 보석만 가져간다.

 */
public class B2792 {

    static int n, m;
    static int[] board;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[m];

        int s = 1;
        int e = 0;
        int mid = 0;
        int sum = 0;

        for(int i = 0; i < m; i++) {
            board[i] = Integer.parseInt(br.readLine());
            e = Math.max(board[i], e);
        }

        while(s <= e) {
            mid = (s+e)/2;
            sum = 0;

            for(int i = 0; i < m; i++) {
                sum += board[i] / mid;
                if(board[i] % mid != 0) {
                    sum++;
                }
            }

            if(sum > n) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        System.out.println(s);

    }


}
