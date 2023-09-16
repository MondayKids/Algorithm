import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_1012_유기농배추 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder   sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=TC; tc++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][M];

            for (int k=0; k<K; k++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            // BFS (인접 1 개수 찾기)
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][M];

            int cnt = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (arr[i][j]==1 && !visited[i][j]) {
                        visited[i][j] = true;
                        q.add(new int[] {i, j});
                        cnt++;

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();

                            int r = cur[0];
                            int c = cur[1];

                            for (int d=0; d<4; d++) {
                                int nr = r + dr[d];
                                int nc = c + dc[d];

                                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

                                if (!visited[nr][nc] && arr[nr][nc]==1) {
                                    visited[nr][nc] = true;
                                    q.add(new int[] {nr, nc});
                                }
                            }
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb.toString());
    }

    private static void print(int[][] arr) {
        for (int i=0; i< arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
