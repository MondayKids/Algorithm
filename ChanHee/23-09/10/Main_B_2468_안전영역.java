import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_2468_안전영역 {
    static int cnt = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i=0; i<arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int high = 1; high <= 100; high++) {
            solve(N, arr, visited, high);
        }

        System.out.println(cnt);
    }

    private static void solve(int N, int[][] arr, boolean[][] visited, int h) {

        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][N];
        int cost = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j] && arr[i][j]>h) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;

                    cost++;
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        int r = cur[0];
                        int c = cur[1];

                        for (int d=0; d<4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr<0 || nr>=N || nc<0 || nc>=N) continue;

                            if (!visited[nr][nc] && arr[nr][nc]>h) {
                                visited[nr][nc] = true;
                                q.add(new int[] {nr, nc});
                            }
                        }
                    }

                }
            }
        }
        if (cost == 0) {
            cost = 1;
        }
        cnt = Math.max(cost, cnt);

    }

    private static void print(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
