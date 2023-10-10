/*
최소 높이 ~ 최대 높이

모든 높이를 순회하며 땅 고르기 수행 (브루트 포스)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/18111
public class Main_B_18111_마인크래프트 {

    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int min = 987654321;
        int max = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (min > map[i][j]) min = map[i][j];
                if (max < map[i][j]) max = map[i][j];
            }
        }

        int time = 987654321;
        int high = 0;

        for (int i=min; i<=max; i++) {
            int count = 0;
            int block = B;

            for (int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    // 기준치 보다 크다면 -> 제거, 시간 +2
                    if (i < map[j][k]) {
                        count += ((map[j][k] - i) * 2);
                        block += (map[j][k] - i); // 제거한 만큼 블록 추가
                    } else { // 기준치 보다 낮다면 -> 블록 쌓기, 시간 +1
                        count += (i - map[j][k]);
                        block -= (i - map[j][k]);
                    }
                }
            }

            // 블록의 개수 음수면 종료
            if (block < 0) break;

            if (time >= count) { // 최소 시간 갱신
                time = count;
                high = i;
            }
        }

        System.out.println(time + " " + high);

    } // main
}
