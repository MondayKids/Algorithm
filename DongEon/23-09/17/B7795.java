package baekjoon.backjoon9.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7795 {

    static int T;

    static int n,m;
    static int[] a;
    static int[] b;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n];
            b = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            solution();

        }

        System.out.println(sb);

    }

    public static void solution() {
        Arrays.sort(a);
        Arrays.sort(b);

        int result = 0;

        for(int i = 0; i < n; i++) {
            result += check(a[i]);
        }

        sb.append(result).append("\n");
    }

    public static int check(int number) {
        int s = 0;
        int e = m-1;

        if(number < b[0]) {
            return 0;
        }

        while(s <= e) {
            int mid = (s+e)/2;

            // number 보다 작은 값들의 개수
            // 중앙값이 number 보다 작음
            if(b[mid] < number) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return s;
    }


}
