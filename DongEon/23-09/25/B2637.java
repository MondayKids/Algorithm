package baekjoon.backjoon9.day25;

/*
장난감 조립
https://www.acmicpc.net/problem/2637
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2637 {

    static int n, m;
    static List<part>[] partList;
    static int[] need; // 필요한 갯수
    static boolean[] basic; // 기본 부품
    static int[] part; // 부품 갯수


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        partList = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            partList[i] = new ArrayList<>();
        }

       need = new int[n+1];

       StringTokenizer st = null;

       for(int i = 0; i < m; i++) {
           st = new StringTokenizer(br.readLine());

           int target = Integer.parseInt(st.nextToken());
           int needIndex = Integer.parseInt(st.nextToken());
           int needNumber = Integer.parseInt(st.nextToken());

           partList[target].add(new part(needIndex, needNumber));

           need[needIndex]++;
       }

       basic = new boolean[n+1];

       for(int i = 1; i < n; i++) {
           if(partList[i].size() == 0) {
               basic[i] = true;
           }
       }

       part = new int[n + 1];
       part[n] = 1;

       Queue<Integer> que = new LinkedList<>();
       que.add(n);


        while (!que.isEmpty()) {
            Integer index = que.poll();

            for(part p : partList[index]) {
                part[p.index] += p.number * part[index];
                need[p.index] -= 1;

                if(need[p.index] == 0) {
                    que.add(p.index);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < n+1; i++) {
            if(basic[i]) {
                sb.append(i).append(" ").append(part[i]).append("\n");
            }
        }

        System.out.println(sb);


    }

    public static class part {
        int index;
        int number;

        part(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }





}
