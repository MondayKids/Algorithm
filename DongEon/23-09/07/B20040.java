package baekjoon.backjoon9.day07;


/*
사이클 게임
https://www.acmicpc.net/problem/20040
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20040 {

    static int n, m;

    static int[] parents;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(find(s) == find(e) && !flag) {
                sb.append(i);
                flag = true;
            }
            else {
                union(s, e);
            }
        }

        if (!flag) {
            sb.append(0);
        }

        System.out.println(sb);





    }

    public static int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        else {
            return find(parents[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) {
                parents[x] = y;
            }
            else {
                parents[y] = x;
            }
        }


    }



}
