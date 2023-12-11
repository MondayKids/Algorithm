import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16234
public class Main_B_16234_인구이동 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> list;
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 지도의 크기
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N]; // 지도
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move()); // 인구이동 결과 출력
    }

    static int move() {
        int result = 0; // 경과시간

        // 인구이동이 없을 때 까지 반복
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N]; // 방문기록배열
            // 방문하지 않은 모든 구역 순회
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);

                        // 인구이동
                        if (list.size() > 1) {
                            change(sum); // 인구수 업데이트
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) return result; // 인구이동 없는 경우 -> 종료
            result++; // 경과시간++
        }
    }

    static int bfs(int r, int c) {
        int sum = map[r][c];

        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        list.add(new int[] {r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d=0; d<4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if (!visited[nr][nc]) {
                    int diff = Math.abs(map[cur[0]][cur[1]] - map[nr][nc]);
                    if (diff>=L && diff<=R) {
                        sum += map[nr][nc]; // 누적 인구수
                        q.add(new int[] {nr, nc});
                        list.add(new int[] {nr, nc});
                        visited[nr][nc] = true; // 방문처리
                    }
                }
            }
        }
        return sum;
    }

    // 인구수 업데이트
    static void change(int sum) {
        int avg = sum / list.size();
        for (int[] x : list) {
            int r = x[0];
            int c = x[1];

            map[r][c] = avg;
        }
    }
}
