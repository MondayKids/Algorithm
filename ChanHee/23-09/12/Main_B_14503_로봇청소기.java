import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_14503_로봇청소기 {

    // 북 동 남 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;

    static int[][] arr;
    static boolean[][] visited;

    private static class Robot {
        private int r;
        private int c;
        private int d;
        private int cnt;

        public Robot(int r, int c, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int rr = Integer.parseInt(st.nextToken());
        int rc = Integer.parseInt(st.nextToken());
        int rd = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(rr, rc, rd, 0);

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        Queue<Robot> q = new LinkedList<>();
        q.add(robot);
        visited[robot.r][robot.c] = true;

        while (!q.isEmpty())
        {
            Robot cur = q.poll();

            int r = cur.r;
            int c = cur.c;
            int d = cur.d;
            int cnt = cur.cnt;


            if (isPresent(cur)) { // 청소 가능한 곳 발견

                for (int i=0; i<4; i++) {
                    d = setAntiRotate(d); // 방향 전환

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= N-1 || nc < 0 || nc >= M-1) continue;

                    if (arr[nr][nc]==0 && !visited[nr][nc])
                    {
                        visited[nr][nc] = true;
                        q.add(new Robot(nr, nc, d, cnt));
                        break;
                    }
                }

            } else {
                // 후진 가능 ???
                if (isPossibleBack(cur)) {
                    int reverseD = (d + 2) % 4;
                    int nr = r + dr[reverseD];
                    int nc = c + dc[reverseD];

                    q.add(new Robot(nr, nc, d, cnt));

                    if (nr<0 || nr>=N-1 || nc<0 || nc>=M-1) break;

                    visited[nr][nc] = true;
                } else {
                    break;
                }
            }
        }

        System.out.println(count_visited(visited));
    }

    // 주변 4방향에 청소되지 않은 빈칸 체크
    private static boolean isPresent(Robot robot) {
        int r = robot.r;
        int c = robot.c;

        for (int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr<0 || nr>=N-1 || nc<0 || nc>=M-1) continue;

            if (arr[nr][nc]==0 && !visited[nr][nc]) return true;

        }

        return false;
    }

    // 반시계 방향으로 90도 회전
    private static int setAntiRotate(int d) {
        // 북 동 남 서
        // 0 1 2 3

        int result = (d - 1) + 4;
        return result % 4;
        // 북 : 0 -> 서 : 3
        // 동 : 1 -> 북 : 0
        // 남 : 2 -> 동 : 1
        // 서 : 3 -> 남 : 2
    }

    private static boolean isPossibleBack(Robot robot) {

        int r = robot.r;
        int c = robot.c;
        int d = robot.d;

        int rd = (d + 2) % 4;
        int nr = r + dr[rd];
        int nc = c + dc[rd];

        if (nr<0 || nr>=N-1 || nc<0 || nc>=M-1) {
            return false;
        }

        if (arr[nr][nc] == 1) {
            return false;
        }

        return true;
    }

    private static void print(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void print_boolean(boolean[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int count_visited(boolean[][] arr) {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
