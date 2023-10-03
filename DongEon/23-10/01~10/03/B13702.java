package baekjoon.backjoon10.day0110.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
이상한 술집
https://www.acmicpc.net/problem/13702
 */
public class B13702 {

    static int n, k;
    static int[] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n];
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        long s = 0;
        long e = (long) Math.pow(2, 31) - 1;

        long answer = 0;

        while(s <= e) {
            long mid = (s+e)/2;

            int result = 0;
            for(int i = 0; i < n; i++) {
                result += board[i] / mid;
            }

            if(result >= k) {
                s = mid + 1;
                answer = mid;
            }
            else {
                e = mid - 1;
            }
        }


        System.out.println(answer);


    }

}
