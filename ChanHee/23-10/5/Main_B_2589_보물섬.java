import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2589
public class Main_B_2589_보물섬 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N, M;
    static char[][] map;
    static int[][] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new char[N][M];

        for (int i=0; i<N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                map[i][j] = temp[j];
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 'L') { // 육지라면
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    } // main

    private static void bfs(int i, int j) {
        visited = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

                if (visited[nr][nc]==0 && map[nr][nc]=='L') {
                    visited[nr][nc] = visited[r][c] + 1;
                    queue.add(new int[] {nr, nc});
                }
            }
        }

        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                if (visited[r][c]-1 > max) {
                    max = visited[r][c]-1;
                }
            }
        }
    }




    private static void print(char[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void print_int(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
