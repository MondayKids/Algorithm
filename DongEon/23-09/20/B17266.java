package baekjoon.backjoon9.day20;

import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B17266 {

    static int n, m;
    static int[] board;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        board = new int[m];

        for (int i = 0; i < m; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }



        int s = 1;
        int e = n;

        int answer = 0;

        while(s <= e) {
            int mid = (s+e)/2;

            if(check(mid)) {
                answer = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }


        }

        System.out.println(answer);


    }

    public static boolean check(int number) {

        int num = 0;

        for(int i = 0; i < m; i++) {
            if(board[i] - number  <= num) {
                num = board[i] + number;
            }
            else {
                return false;
            }
        }

        return n - num <= 0;


    }

}
