package baekjoon.backjoon10.day1120.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
줄세우기
https://www.acmicpc.net/problem/10431
 */
public class B10431 {

    static int testcase;
    static StringBuilder sb;
    static int[] board;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int test = 1; test <= testcase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int caseNumber = Integer.parseInt(st.nextToken());
            board = new int[20];
            for(int i = 0; i < 20; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(caseNumber).append(" ");
            simulation();
            sb.append("\n");

        }

        System.out.println(sb);


    }

    // 나보다 큰 애가 몇 명 있는지 구하면 된다.
    public static void simulation() {

        List<Integer> line = new ArrayList<>();
        line.add(board[0]);
        int result = 0;

        for(int i = 1; i < 20; i++) {
            int student = board[i];
            for(int data : line) {
                if(student < data) {
                    result++;
                }
            }
            line.add(student);
        }
        sb.append(result);
    }
}
