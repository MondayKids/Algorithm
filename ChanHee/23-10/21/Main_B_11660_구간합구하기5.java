import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1 3 6 10
2 5 9 14
3 7 12 18
4 9 15 22

ex) 2,2 ~ 3,3
dp[2][3] - dp[2][1] = 5 + 9
dp[3][3] - dp[3][1] = 7 + 12

 */

// https://www.acmicpc.net/problem/11660
public class Main_B_11660_구간합구하기5 {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder   sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                sum[i][j] = map[i][j] + sum[i][j-1];
            }
        }

        for (int i=0; i<M; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int r=x1; r<=x2; r++) {
                int temp = sum[r][y2] - sum[r][y1-1];
                answer += temp;
            }
            sb.append(answer).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
