/*
0 : 빈 칸
1 : 집
2 : 치킨집

[1, 1]

            [N, N]

M : 폐업 시키지 않을 치킨집 개수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15686
public class Main_B_15686_치킨배달 {

    static int N, M;
    static int[][] map;
    static List<int[]> chickList;
    static List<int[]> houseList;

    static int[] chickArr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        chickList = new ArrayList<>();
        houseList = new ArrayList<>();

        chickArr = new int[M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j]==2) {
                    chickList.add(new int[] {i, j}); // 치킨집 좌표 기록
                } else if (map[i][j]==1) {
                    houseList.add(new int[] {i, j}); // 집 좌표 기록
                }
            }
        }

        answer = Integer.MAX_VALUE;
        solve(0, 0);
        System.out.println(answer);

    }

    private static void solve(int start, int cnt) {
        if (cnt == M) {
            // System.out.println(Arrays.toString(chickArr)); // 영업하는 치킨 집 좌표

            // Todo : temp 에서 치킨 거리 구하기
            // 집 리스트 <-> 영업하는 치킨집 리스트
            int sum = 0;
            for (int[] data1 : houseList) {
                int min = Integer.MAX_VALUE;
                for (int idx : chickArr) {
                    int[] data2 = chickList.get(idx);
                    min = Math.min(manDistance(data1, data2), min);
                }
                sum += min;
            }

            answer = Math.min(answer, sum);
            return;
        }

        for (int i=start; i<chickList.size(); i++) {
            chickArr[cnt] = i;
            solve(i+1, cnt+1);

        }
    }

    private static int manDistance(int[] d1, int[] d2) {
        int r1 = d1[0];
        int c1 = d1[1];
        int r2 = d2[0];
        int c2 = d2[1];
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
