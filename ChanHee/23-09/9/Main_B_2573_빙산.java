import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2573
public class Main_B_2573_빙산 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        // 종료 조건 : 두 덩어리로 나뉨 or 빙하 높이가 모두 0
        while (!check1()) {
            if (check2()) {
                ans = 0;
                break;
            }
            solve(); // 1년 후
            ans++;
        }

        System.out.print(ans);
    }

    // 두 덩어리로 나뉘었는가 판단
    private static boolean check1() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {

                if (arr[i][j] != 0 && !visited[i][j]) {
                    cnt++;

                    if (cnt >= 2) {
                        return true;
                    }

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

                            if (!visited[nr][nc] && arr[nr][nc] != 0) {
                                q.add(new int[] {nr, nc});
                                visited[nr][nc] = true;
                            }

                        }
                    }
                }
            }
        }

        return false;
    }

    // 빙하가 다 녹았는지 판단
    private static boolean check2() {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] != 0) {
                    cnt++;
                }
            }
        }
        return cnt == 0;
    }

    // 1년 후 빙하 상태 변경 
    private static void solve() {

        int[][] temp = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                temp[i][j] = arr[i][j];
            }
        }


        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int[] node = new int[] {i, j};

                if (arr[i][j] != 0) {
                    int cnt = count(node, temp);
                    arr[i][j] = Math.max(0, (arr[i][j] - cnt));
                }
            }
        }

    }

    // 좌표 주변 빙하 개수 리턴 
    private static int count(int[] node, int[][] arr) {
        int r = node[0];
        int c = node[1];

        int cnt = 0;
        for (int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

            if (arr[nr][nc] == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
