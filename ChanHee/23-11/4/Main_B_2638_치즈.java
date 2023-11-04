import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2638
public class Main_B_2638_치즈 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M; // 행 열
    static int[][] map; // 지도

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        // 지도 입력
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 치즈 다 녹는 경과일
        int day = 0;

        // 다 안녹았으면 반복
        while (!isFinish()) {
            BFS(); // 공기 접촉 2회 이상 치즈 제거
            day++; // 날짜 경과
        }
        System.out.println(day); // 치즈 녹은 경과일 출력
    } // main

    // 공기 접촉 2회 이상 치즈 제거
    private static void BFS() {
        int[][] visited = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0}); // 가장 자리는 치즈가 놓이지 않았으므로
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 체크
                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

                // 치즈라면
                if (map[nr][nc] == 1) {
                    visited[nr][nc] += 1; // 외부 공기 방문 기록
                } else if (visited[nr][nc] == 0) { // 치즈가 아니고 한번도 방문 안한 공백이라면
                    visited[nr][nc] = 1;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        // 공기 방문 2회 이상인 치즈 제거
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] >= 2) map[i][j] = 0;
            }
        }
    }

    // 치즈 다 녹았는지 체크
    private static boolean isFinish() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1) return false;
            }
        }

        return true;
    }
}
