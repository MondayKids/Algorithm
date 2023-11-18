import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4963
public class Main_B_4963_섬의개수 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int w, h; // 너비, 높이
    static int[][] map; // 지도

    // 상 하 좌 우 좌상 우상 좌하 우하
    static final int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static final int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w==0 && h==0) break; // 종료 조건

            map = new int[h][w];
            input(map, st); // 지도 입력 받기

            int count = getCount(map); // 섬의 개수 구하기
            sb.append(count).append("\n");
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    private static void input(int[][] map, StringTokenizer st) throws IOException {
        for (int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int getCount(int[][] map) {
        int result = 0;

        boolean[][] visited = new boolean[h][w];

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (map[i][j]==1 && !visited[i][j]) { // 땅 + 방문안함

                    // 섬++
                    result++;

                    // 8방향 탐색
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        int r = cur[0];
                        int c = cur[1];

                        for (int d=0; d<dr.length; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr<0 || nr>=h || nc<0 || nc>=w) continue;
                            if (!visited[nr][nc] && map[nr][nc]==1) {
                                q.add(new int[] {nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    private static void print(int[][] map) {
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
