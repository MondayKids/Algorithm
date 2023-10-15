import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7576
public class Main_B_7576_토마토 {

    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};

    static int time = 0; // 경과 시간
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1)
                    q.add(new int[] {i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if (arr[nr][nc] == 0) {
                    arr[nr][nc] = arr[r][c] + 1;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        if (isFinish(arr)) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    time = Math.max(time, arr[i][j]);
                }
            }
            System.out.println(time - 1);
        } else {
            System.out.println(-1);
        }
    }

    static boolean isFinish(int[][] arr) {

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j]==0) return false;
            }
        }

        return true;
    }

    static void print(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
