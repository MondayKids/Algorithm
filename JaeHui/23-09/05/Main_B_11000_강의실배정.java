package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_B_11000_강의실배정 {

    static class Lecture implements Comparable<Lecture> {
        int s;
        int t;

        Lecture(int s, int t) {
            this.s = s;
            this.t = t;
        }


        @Override
        public int compareTo(Lecture o) {
            return this.s == o.s ? this.t - o.t : this.s - o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s, t);
        }
        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].t);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].s) pq.poll();
            pq.add(lectures[i].t);
        }

        System.out.println(pq.size());
        br.close();
    }
}
