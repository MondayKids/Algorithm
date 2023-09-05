package baekjoon.backjoon9.day05;


/*

서강그라운드
https://www.acmicpc.net/problem/14938

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14938 {

    static int n; // 지역 개수
    static int m; // 수색 범위
    static int r; // 길의 개수

    static int[] item;
    static int[][] board;

    static int INT = 987654321;

    static int answer; // 최대로 많은 개수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        board = new int[n + 1][n + 1];
        int s,e,c;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            board[s][e] = c;
            board[e][s] = c;
        }

        answer = 0;

        for (int i = 1; i < n + 1; i++) {
            search(i);
        }


        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);

    }

    // 다익스트라 풀이
    // 다익스트라는 한 번 방문해도 더 적은 비용으로 방문할 수 있으면 갈아치운다.
    public static void search(int start) {

        int result = 0;

        int[] costList = new int[n + 1];
        Arrays.fill(costList, Integer.MAX_VALUE);

        costList[start] = 0;

        PriorityQueue<dot> pq = new PriorityQueue<dot>();

        pq.add(new dot(start, 0));

        while (!pq.isEmpty()) {
            dot d = pq.poll();

            for (int i = 1; i < n + 1; i++) {
                if(board[d.node][i] > 0 && costList[i] > d.cost + board[d.node][i]) {
                    costList[i] = d.cost + board[d.node][i];
                    pq.add(new dot(i, d.cost + board[d.node][i]));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if(costList[i] <= m) {
                result += item[i];
            }
        }

        answer = Math.max(answer, result);


    }


    public static class dot implements Comparable<dot>  {
        int node;
        int cost;

        dot(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(dot dot) {
            return this.cost - dot.cost;
        }

    }

}
