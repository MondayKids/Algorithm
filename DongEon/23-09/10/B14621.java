package baekjoon.backjoon9.day10;

/*

나만 안되는 연애
https://www.acmicpc.net/problem/14621

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14621 {

    static int n, m;
    static int[] gender;
    static PriorityQueue<dot> pq;
    static int[] parents;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        gender = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(st.nextToken().equals("M")) {
                gender[i] = 1;
            }
            else {
                gender[i] = 2;
            }
        }

        int s, e, cost;
        pq = new PriorityQueue<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            if(gender[s] != gender[e]) {
                pq.add(new dot(s, e, cost));
            }
        }

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        int result = 0;
        boolean flag = true;
        int count = 0;

        while (!pq.isEmpty()) {
            dot d = pq.poll();

            if(find(d.s) != find(d.e)) {
                union(d.s, d.e);
                result += d.cost;
                count++;
            }
        }

        if(count != n-1) {
            flag = false;
        }

        for(int i = 1; i < n+1; i++) {
            if(find(1) != find(i)) {
                flag = false;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(flag == false) {
            answer = -1;
        }
        else {
            answer = result;
        }

        sb.append(answer);
        System.out.println(answer);


    }


    public static int find(int x) {
        if(parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y) {
            parents[x] = y;
        }
        else {
            parents[y] = x;
        }
    }

    public static class dot implements Comparable<dot> {
        int s;
        int e;
        int cost;

        dot(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        public int compareTo(dot d) {
            return this.cost - d.cost;
        }
    }
}
