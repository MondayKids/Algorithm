import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7562
public class Main_B_7562_나이트의이동 {

    // 8방향
    static int[] dr = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] dc = {-1, 1, -1, 1, -2, 2, -2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=TC; tc++) {
            int N = Integer.parseInt(br.readLine());

            boolean[][] visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine(), " ");
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int gr = Integer.parseInt(st.nextToken());
            int gc = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {sr, sc, 0});
            visited[sr][sc] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int cnt = cur[2];

                if (r==gr && c==gc) {
                    sb.append(cnt).append("\n");
                }

                for (int d=0; d<8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr<0 || nr>=N || nc<0 || nc>=N) continue;

                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc, cnt+1});
                    }
                }
            }
        }
        System.out.println(sb.toString());
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
