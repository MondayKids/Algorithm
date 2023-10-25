package baekjoon.backjoon10.day2131.day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/*
캠프 준비
https://www.acmicpc.net/problem/16938
 */

public class B16938 {


    static int n, l, r, x;
    static int[] problem;
    static int answer;
    static boolean[] selected;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 문제 개수
        l = Integer.parseInt(st.nextToken()); // 문제 난이도 합 최소값
        r = Integer.parseInt(st.nextToken()); // 문제 난이도 합 최대값
        x = Integer.parseInt(st.nextToken()); // 문제 나이도 차이

        problem = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;

        selected = new boolean[n];
        dfs(0, 0);

        System.out.println(answer);

    }

    public static void dfs(int stage, int number) {

        if(stage >= 2) {
            int minValue = Integer.MAX_VALUE;
            int maxValue = 0;
            int sumValue = 0;

            for(int i = 0; i < n; i++) {
                if(selected[i]) {
                    minValue = Math.min(problem[i], minValue);
                    maxValue = Math.max(problem[i], maxValue);
                    sumValue += problem[i];
                }
            }

            if(sumValue > r) {
                return;
            }

            if(sumValue >= l && sumValue <= r && maxValue - minValue >= x) {
                answer += 1;
            }

        }

        for(int i = number; i < n; i++) {
            if(selected[i] == false) {
                selected[i] = true;
                dfs(stage+1, i+1);
                selected[i] = false;
            }
        }

    }




}
