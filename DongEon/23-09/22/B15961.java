package baekjoon.backjoon9.day22;

/*

회전 초밥
https://www.acmicpc.net/problem/15961

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15961 {

    static int n, d, k, c;
    static int[] board;

    static Set<Integer> select;

    static int[] count;

    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[n + k];
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < k; i++) {
            board[n+i] = board[i];
        }

        count = new int[d+1];
        select = new HashSet<>();
        select.add(c);
        count[c] = k+1;

        answer = select.size();



        for(int i = 0; i < k; i++) {
            select.add(board[i]);
            count[board[i]]++;
        }

        answer = select.size();

        for(int i = k; i < n+k; i++) {
            select.add(board[i]);
            count[board[i]]++;

            if(board[i-k] != c) {
                count[board[i-k]]--;
                if(count[board[i-k]] == 0) {
                    select.remove(board[i-k]);
                }
            }

            answer = Math.max(answer, select.size());

        }


        System.out.println(answer);



    }

}
