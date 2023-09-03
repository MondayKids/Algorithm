import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2178
public class Main_B_2178_미로탐색 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i=0; i<N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(temp[j]));
            }
        }

        boolean[][] visited = new boolean[N][M];
        int[] dr = new int[] {-1, 1, 0, 0};
        int[] dc = new int[] {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

                if (arr[nr][nc] != 0 && !visited[nr][nc]) {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    arr[nr][nc] = arr[r][c] + 1;
                }
            }
        }

        System.out.println(arr[N-1][M-1]);
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
