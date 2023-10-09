package baekjoon.backjoon10.day0110.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;


/*
배
https://www.acmicpc.net/problem/1092
 */

public class B1092 {

    static int n;
    static List<Integer> cranes;

    static int m;
    static List<Integer> boxs;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cranes = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        boxs = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            boxs.add(Integer.parseInt(st.nextToken()));
        }

        // 내림차순 정렬
        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxs, Collections.reverseOrder());


        // 크레인이 들 수 없는 박스가 있는 경우 -1 출력
        if(cranes.get(0) < boxs.get(0)) {
            System.out.println(-1);
            return;
        }

        int answer = 0; // 시간

        while(!boxs.isEmpty()) {

            int boxIndex = 0;

            for(int i = 0; i < n; i++) {
                int crane = cranes.get(i);

                while(true) {

                    if(boxIndex == boxs.size()) {
                        break;
                    }

                    if(crane >= boxs.get(boxIndex)) {
                        boxs.remove(boxIndex);
                        break;
                    }
                    boxIndex++;
                }
            }

            answer++;

        }

        System.out.println(answer);









    }

}
