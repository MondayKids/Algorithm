import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14500
public class Main_B_14500_테트로미노 {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

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

        // 모든 경우를 구한다.
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    // 현재 위치에서 4칸을 만들었을 때, 합을 구한다.
    private static void dfs(int row, int col, int sum, int count) {

        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        for (int i=0; i<4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            // 범위 체크
            if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

            // 아직 방문하지 않았다면
            if (!visited[nr][nc]) {
                if (count == 2) { // ㅗ 모양을 만들기 위함.
                    visited[nr][nc] = true;
                    dfs(row, col, sum+arr[nr][nc], count+1);
                    visited[nr][nc] = false;
                }

                visited[nr][nc] = true;
                dfs(nr, nc, sum+arr[nr][nc], count+1);
                visited[nr][nc] = false;
            }
        }
    }
}
