package baekjoon.backjoon9.day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
계란으로 계란치기
https://www.acmicpc.net/problem/16987

내구도와 무게가 주어진다.
계란끼리 부딫히면 무게 만큼 내구도가 감소한다.
 */
public class B16987 {

    static int n;
    static int[][] eggs;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }

        answer = 0;

        dfs(0);

        System.out.println(answer);

    }

    public static void dfs(int stage) {

        if(stage == n) {
            int result = 0;
            for(int i = 0; i < n; i++) {
                if(eggs[i][0] <= 0) {
                    result++;
                }
            }
            answer = Math.max(answer, result);
            return;
        }

        int durability = eggs[stage][0];
        int weight = eggs[stage][1];

        // 이미 깨진 계란은 넘어간다.
        if(durability <= 0) {
            dfs(stage+1);
        }
        else {

            boolean flag = false;

            for(int i = 0; i < n; i++) {
                if(i == stage) {
                    continue;
                }

                if(eggs[i][0] > 0) {
                    flag = true;

                    eggs[i][0] -= weight;
                    eggs[stage][0] -= eggs[i][1];
                    dfs(stage+1);
                    eggs[i][0] += weight;
                    eggs[stage][0] += eggs[i][1];
                }
            }

            if(flag == false) {
                dfs(stage + 1);
            }
        }
    }
}
