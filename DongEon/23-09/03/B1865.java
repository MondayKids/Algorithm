package baekjoon.backjoon9.day03;


import java.util.*;
import java.lang.*;
import java.io.*;

/*
웜홀
https://www.acmicpc.net/problem/1865

벨만 포드 알고리즘


 */

public class B1865 {

    static int n; // 지점
    static int m; // 도로
    static int w; // 웜홀

    static int tc; // 테스트 케이스 개수

    static int INF = 987654321;
    static int[] dist;
    static List<dot>[] road;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            road = new List[n+1];
            for (int j = 0; j < n + 1; j++) {
                road[j] = new ArrayList<>();
            }
            dist = new int[n + 1];

            int s = 0;
            int e = 0;
            int t = 0;


            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());

                // 도로는 양방향.. 업데이트를 처야하는데
                road[s].add(new dot(e, t));
                road[e].add(new dot(s, t));
            }

            for(int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());

                // 웜홀은 단방향
                road[s].add(new dot(e, -t));
            }

            boolean check = false;

            for (int j = 1; j <= n; j++) {
                if (bellmanford(j)) {
                    check = true;
                    break;
                }
            }

            if (check ) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);



    }

    public static boolean bellmanford(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean isUpdated = false;

        for (int i = 0; i < n; i++) {
            isUpdated = false;
            for (int j = 1; j < n + 1; j++) {
                int cur = j;
                for (dot data : road[j]) {
                    if (dist[data.node] > dist[cur] + data.cost) {
                        dist[data.node] = dist[cur] + data.cost;
                        isUpdated = true;
                        if (i == n - 1) {
                            return true;
                        }
                    }
                }
            }

            if(!isUpdated) break;
        }

        return false;

    }


    public static class dot {
        int node;
        int cost;

        dot(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

}
