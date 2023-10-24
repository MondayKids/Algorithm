package baekjoon.backjoon10.day2131.day24;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
흙길 보수하기
https://www.acmicpc.net/problem/1911
 */
public class B1911 {

    static int n;
    static int l;
    static List<WaterHole> waterHoleList;

    static int range;
    static int answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        waterHoleList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            waterHoleList.add(new WaterHole(start, end));
        }

        Collections.sort(waterHoleList);

        range = 0;
        answer = 0;

        for(WaterHole data : waterHoleList) {

            if(data.start > range) {
                range = data.start;
            }

            while(true) {
                if(data.end > range) {
                    range += l;
                    answer++;
                }
                else {
                    break;
                }
            }

        }

        System.out.println(answer);

    }


    public static class WaterHole implements Comparable<WaterHole> {
        int start;
        int end;

        WaterHole(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(WaterHole w) {
            if(this.start == w.start) {
                return this.end - w.end;
            }
            return this.start - w.start;
        }

    }

}
