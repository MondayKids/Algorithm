package baekjoon.backjoon9.day23;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
히오스 프로게이머
https://www.acmicpc.net/problem/16564
 */
public class B16564 {

    static int n, k;
    static long[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        level = new long[n];

        long small = 1_000_000_000;
        long large = 1;

        for(int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());

            small = Math.min(small, level[i]);
            large = Math.max(large, level[i]);
        }

        long s = small;
        long e = large + k;

        long answer = 0;

        while(s <= e) {
            long mid = (s+e)/2;

            if(check(mid)) {
               s = mid + 1;
               answer = mid;
            }
            else {
                e = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(long number) {
        long result = 0;

        for(int i = 0; i < n; i++) {
            if(number > level[i]) {
                result += number - level[i];
            }
        }

        if(result <= k) {
            return true;
        }
        else {
            return false;
        }
    }

}
