package baekjoon.backjoon9.day19;

/*
용돈 관리
https://www.acmicpc.net/problem/6236
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6236 {

    static int n,m;
    static int[] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n];
        int largeNumber = 0;
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(br.readLine());
            largeNumber = Math.max(largeNumber, board[i]);
        }

        int s = largeNumber;

        // N의 최댓값, M의 최댓값의 곱
        // e의 가장 큰 값은 M이 1일 때 N의 최대 일수인 10000일을 한 번에 인출해서 버틸 금액이어야 한다.
        // 즉 10_000 * 100_000 이어야 한다.
        // 맨 처음 Integer.MAX_VALUE 해서 42%에서 틀렸다.
        int e = 10_000 * 100_000;



        int answer = 0;

        while(s <= e) {
            int mid = (s+e)/2;

            int count = 1;
            int money = mid;

            for(int i = 0; i < n; i++) {
                money -= board[i];

                if(money < 0) {
                    money = mid - board[i];
                    count++;
                }
            }

            if(count > m) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);




    }

}
