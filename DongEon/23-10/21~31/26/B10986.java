package baekjoon.backjoon10.day2131.day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
나머지 합
https://www.acmicpc.net/problem/10986


 */
public class B10986 {

    static int n,m;
    static int[] board;
    static long[] prefix;
    static int[] remainder;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        prefix = new long[n];
        long before = 0;
        for(int i = 0; i < n; i++) {
            prefix[i] = before + board[i];
            before = prefix[i];
        }

        long answer = 0;
        remainder = new int[m];
        /*
        런타임 에러 (ArrayIndexOutOfBounds) -> 에러 터진 지점
        연산을 한 다음에 형변환을 하자
           for(int i = 0; i < n; i++) {
            int number = (int) prefix[i] % m;
            if(number == 0) {
                answer += 1;
            }
            remainder[number] += 1;
        }
         */
        for(int i = 0; i < n; i++) {
            long number = prefix[i] % m;
            if(number == 0) {
                answer += 1;
            }
            remainder[(int) number] += 1;
        }

        for(int i = 0; i < m; i++) {
            if(remainder[i] >= 2) {
                answer += (((long) remainder[i] * (remainder[i]-1)) / 2);
            }
        }

        System.out.println(answer);



    }


}
