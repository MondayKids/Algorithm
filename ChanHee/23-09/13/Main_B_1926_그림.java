import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1926
public class Main_B_1926_그림 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;

    static int pCnt = 0; // 그림 개수 최대값
    static int pArea = 0; // 그림 넓이 최대값

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(pCnt);
        System.out.println(pArea);
    }

    private static void solve() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j] && arr[i][j]==1) {
                    pCnt++;

                    int temp = 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        int r = cur[0];
                        int c = cur[1];

                        for (int d=0; d<4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

                            if (arr[nr][nc]==1 && !visited[nr][nc]) {
                                q.add(new int[] {nr, nc});
                                visited[nr][nc] = true;
                                temp++;
                            }
                        }
                    }

                    pArea = Math.max(pArea, temp);
                }
            }
        }
    }

    private static void print(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
