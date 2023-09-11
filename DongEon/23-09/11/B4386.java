package baekjoon.backjoon9.day11;

/*
별자리 만들기
https://www.acmicpc.net/problem/4386
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B4386 {

    static int n;
    static double[][] board;
    static PriorityQueue<dot> pq;

    static int[] parents;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new double[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Double.parseDouble(st.nextToken());
            board[i][1] = Double.parseDouble(st.nextToken());
        }

        pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                double distance = Math.sqrt(Math.pow(board[i][0] - board[j][0], 2) + Math.pow(board[i][1] - board[j][1], 2));
                pq.add(new dot(i, j, distance));
            }
        }

        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        double answer = 0.0;

        while (!pq.isEmpty()) {
            dot d = pq.poll();

            if(find(d.s) != find(d.e)) {
                answer += d.cost;
                union(d.s, d.e);

                if(check()) {
                    break;
                }
            }
        }

        System.out.println(String.format("%.2f", answer));

    }

    public static boolean check() {
        for(int i = 0; i < n; i++) {
            if(find(0) != find(i)) {
                return false;
            }
        }
        return true;
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
        double cost;

        dot(int s, int e, double cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        public int compareTo(dot d) {
            if(this.cost < d.cost) {
                return -1; // 현재객체가 매개변수 객체보다 앞에 위치해야함
            }
            if(this.cost > d.cost) {
                return 1; // 현재객체가 매개변수객체보다 뒤에 위치해야함
            }
            return 0;

        }
    }

}
