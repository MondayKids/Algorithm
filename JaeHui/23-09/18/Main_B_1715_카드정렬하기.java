package BOJ;

import java.io.*;
import java.util.*;

public class Main_B_1715_카드정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));

        int answer = 0;
        int fir, sec;
        while(pq.size() > 1) {
            fir = pq.poll();
            sec = pq.poll();

            answer += fir + sec;
            pq.add(fir + sec);
        }

        System.out.println(answer);
        br.close();
    }
}
