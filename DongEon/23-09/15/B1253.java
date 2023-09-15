package baekjoon.backjoon9.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
좋다
https://www.acmicpc.net/problem/1253
 */
public class B1253 {

    static int n;
    static int[] board;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board);

        answer = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int target = board[i];
            int s = 0;
            int e = n-1;

            while(s < e) {
                int sum = board[s] + board[e];

                if(sum == target) {
                    if(s == e) {
                        s++;
                    }
                    else if(s == i) {
                        s++;
                    }
                    else if(e == i) {
                        e--;
                    }
                    else {
                        answer++;
                        break;
                    }
                }

                if(sum > target) {
                    e--;
                }
                else if(sum < target) {
                    s++;
                }




            }
        }

        sb.append(answer);
        System.out.println(sb);

    }


}
