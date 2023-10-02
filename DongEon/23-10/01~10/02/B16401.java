package baekjoon.backjoon10.day0110.day02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
과자 나눠주기
https://www.acmicpc.net/problem/16401
 */
public class B16401 {

    static int m, n;
    static long[] board;
    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            board[i] = Long.parseLong(st.nextToken());
        }

        long s = 1;
        long e = 1_000_000_000;
        answer = 0;

        while(s <= e) {
            long mid = (s+e)/2;

            int result = 0;
            for(int i = 0; i < n; i++) {
                result += board[i] / mid;
            }

            // 조건 충족
            if (result >= m) {
                s = mid+1;
                answer = mid;
            }
            else {
                e = mid-1;
            }
        }

        System.out.println(answer);


    }

}
