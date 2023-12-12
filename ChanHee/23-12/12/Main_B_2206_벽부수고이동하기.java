/*
벽을 부순 경우 or 부수지 않은 경우 3차원 배열
메모이제이션

1000 1000 -> 1000_000

100만 * 100만가지 벽을 부수는 경우 -> 시간초과
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/2206
public class Main_B_2206_벽부수고이동하기 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N, M;
    static char[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        map = new char[N][M];
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        bfs();
    }

    static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0, 1}); // 시작점
        visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int isDestroyed = cur[2];
            int cnt = cur[3];

            if (r == N-1 && c == M-1) {
                System.out.println(cnt);
                return;
            }

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

                int next_cnt = cnt + 1;

                if (map[nr][nc] == '0') { // 평지
                    if (isDestroyed == 0 && !visited[nr][nc][0]) { // 벽을 부신적 없으면
                        q.add(new int[] {nr, nc, 0, next_cnt});
                        visited[nr][nc][0] = true;
                    } else if (isDestroyed == 1 && !visited[nr][nc][1]) { // 벽 1번 부신적 있음
                        q.add(new int[] {nr, nc, 1, next_cnt});
                        visited[nr][nc][1] = true;
                    }
                } else if (map[nr][nc] == '1') { // 벽
                    if (isDestroyed == 0) { // 벽 부순적 없으면
                        q.add(new int[] {nr, nc, 1, next_cnt});
                        visited[nr][nc][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
