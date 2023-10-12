package baekjoon.backjoon10.day1120.day11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
최대 힙
https://www.acmicpc.net/problem/11279
 */
public class B11279 {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            // 출력
            if(input == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    Integer poll = pq.poll();
                    sb.append(poll).append("\n");
                }
            }
            else if(input > 0) {
                pq.add(input);
            }
        }

        System.out.println(sb.toString());


    }
}
