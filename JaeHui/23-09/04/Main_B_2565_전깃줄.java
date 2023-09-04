package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_2565_전깃줄 {

    static class Line implements Comparable<Line> {
        int a;
        int b;

        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line o) {
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N + 1];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        lines[0] = new Line(0, 0);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i] = new Line(a, b);
        }
        Arrays.sort(lines);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (lines[i].b > lines[j].b) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        System.out.println(N - Arrays.stream(dp).max().getAsInt());
        br.close();
    }
}
