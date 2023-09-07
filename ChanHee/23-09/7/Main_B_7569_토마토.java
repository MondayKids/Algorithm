import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7569
public class Main_B_7569_토마토 {

    // 위 아래 왼 오른 앞 뒤 (6방향)
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};
    static int[] dh = {-1, 1};

    static int M;
    static int N;
    static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // 상자 가로 칸의 수 (열)
        N = Integer.parseInt(st.nextToken()); // 상자 세로 칸의 수 (행)
        H = Integer.parseInt(st.nextToken()); // 상자의 수 (높이)

        int[][][] arr = new int[N][M][H];

        Queue<int[]> q = new LinkedList<>();

        for (int h=0; h<H; h++) {
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<M; j++) {
                    arr[i][j][h] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][h] == 1) {
                        q.add(new int[] {i, j, h, 0});
                    }
                }
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int h = cur[2];
            int cnt = cur[3];

            ans = Math.max(cnt, ans);

            for (int d=0; d<4; d++) { // 앞 뒤 좌 우
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if (arr[nr][nc][h] == -1) continue;

                if (arr[nr][nc][h] == 0) {
                    q.add(new int[] {nr, nc, h, cnt+1});
                    arr[nr][nc][h] = 1;
                }
            }

            for (int d=0; d<2; d++) { // 상 하
                int nh = h + dh[d];

                if (nh<0 || nh>=H) continue;
                if (arr[r][c][nh] == -1) continue;

                if (arr[r][c][nh] == 0) {
                    q.add(new int[] {r, c, nh, cnt+1});
                    arr[r][c][nh] = 1;
                }
            }
        }

        if (!isContagious(arr)) {
            ans = -1;
        }

        System.out.println(ans);
    }

    private static void print(int[][][] arr) {
        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    System.out.print(arr[j][k][i] + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean isContagious(int[][][] arr) {
        for (int h=0; h<H; h++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (arr[i][j][h] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
