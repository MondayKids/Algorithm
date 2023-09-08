package baekjoon.backjoon9.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2467 {

    static int n;
    static long[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        board = new long[n];
        for(int i = 0; i < n; i++) {
            board[i] = Long.parseLong(st.nextToken());
        }

        int s = 0;
        int e = n-1;

        Arrays.sort(board);

        // 투 포인터
        long result = Long.MAX_VALUE;
        long answer1 = 0;
        long answer2 = 0;


        while(s < e) {
            long check = board[s] + board[e];

            if(check == 0) {
                answer1 = board[s];
                answer2 = board[e];
                break;
            }
            else if(check > 0) {
                if (Math.abs(result) > Math.abs(check)) {
                    result = check;
                    answer1 = board[s];
                    answer2 = board[e];
                }
                e = e-1;
            }
            else if(check < 0) {
                if (Math.abs(result) > Math.abs(check)) {
                    result = check;
                    answer1 = board[s];
                    answer2 = board[e];
                }
                s = s+1;
            }

        }





        StringBuilder sb = new StringBuilder();
        sb.append(answer1 + " " + answer2);
        System.out.println(sb);

    }

}
