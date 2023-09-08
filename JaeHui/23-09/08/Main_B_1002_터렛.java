package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1002_터렛 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        double distance;
        int[] x = new int[2];
        int[] y = new int[2];
        int[] r = new int[2];

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                r[i] = Integer.parseInt(st.nextToken());
            }
            distance = Math.sqrt(Math.pow(x[0] - x[1], 2) + Math.pow(y[0] - y[1], 2));

            if (distance == 0 && r[0] == r[1]) sb.append(-1).append("\n");
            else if (Math.abs(r[0] - r[1]) == distance || r[0] + r[1] == distance) sb.append(1).append("\n");
            else if (Math.abs(r[0] - r[1]) < distance && distance < r[0] + r[1]) sb.append(2).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

}
