/*
0, 0 -> BFS -> 1만나면 체크
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2636
public class Main_B_2636_치즈 {

    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] map2;
    static int preCheese;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (!isFinish()) {
            check();
            delete();
            time++;
        }
        System.out.println(time);
        System.out.println(preCheese);
    }

    static void check() {
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        map2 = new int[N][M];
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if (visited[nr][nc]) continue;

                if (map[nr][nc] == 0) {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                } else if (map[nr][nc] == 1) {
                    map2[nr][nc] = 1;
                }
            }
        }
    }

    static void delete() {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map2[i][j] == 1) {
                    map[i][j] = 0; // 치즈 녹이기
                    cnt++;
                }
            }
        }
        preCheese = cnt;
    }

    static boolean isFinish() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }
}
