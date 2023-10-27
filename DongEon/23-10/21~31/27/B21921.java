package baekjoon.backjoon10.day2131.day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
블로그
https://www.acmicpc.net/problem/21921
 */
public class B21921 {

    static int n, x;
    static int[] board;
    static int[] prefix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        board = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        prefix = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            prefix[i] = prefix[i-1] + board[i-1];
        }

        int answer = 0;
        int count = 0;
        for(int i = 1; i < n+1-x+1; i++) {
            int number = prefix[i+x-1] - prefix[i-1];
            if(answer == number) {
                count += 1;
            }

            if(number > answer) {
                answer = number;
                count = 1;
            }


        }

        if(answer == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(answer);
            System.out.println(count);
        }


    }

}
