package baekjoon.backjoon9.day26;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
음악프로그램
https://www.acmicpc.net/problem/2623
 */
public class B2623 {

    static int n, m;

    static int[] need;
    static List<Integer>[] orderList;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        need = new int[n+1];
        orderList = new List[n+1];
        for(int i = 0; i < n+1; i++) {
            orderList[i] = new ArrayList<>();
        }


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            for(int j = 1; j < num; j++) {
                int end = Integer.parseInt(st.nextToken());
                need[end] += 1;
                orderList[start].add(end);
                start = end;
            }
        }


        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i < n+1; i++) {
            if(need[i] == 0) {
                que.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!que.isEmpty()) {
            Integer p = que.poll();

            count++;
            sb.append(p).append("\n");

            for(int data : orderList[p]) {
                need[data] -= 1;

                if(need[data] == 0) {
                    que.add(data);
                }
            }
        }
        
        // 불가능 : 사이클 확인 1 -> 3 -> 1 같은 경우
        if(count != n) {
            System.out.println(0);
            return;
        }

        System.out.println(sb);



    }

}
