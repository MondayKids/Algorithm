import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/14502
public class Main_B_14502_연구소 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;
    static int[][] map2;
    static List<int[]> list;
    static int[] selected;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        selected = new int[3];

        list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new int[] {i, j});
                }
            }
        }

        solve(0, 0);
        System.out.println(max);
    }

    private static void solve(int cnt, int v) {
        if (cnt == 3) {
            // System.out.println(Arrays.toString(selected));
            // 벽 세우기
            map2 = new int[N][M];
            for (int i=0; i< map.length; i++) {
                for (int j=0; j<map[i].length; j++) {
                    map2[i][j] = map[i][j];
                }
            }

            for (int x : selected) {
                int[] cur = list.get(x);
                map2[cur[0]][cur[1]] = 1;
            }

            // 바이러스 확산
            spread(map2);
            return;
        }

        for (int i=v; i<list.size(); i++) {
            selected[cnt] = i;
            solve(cnt + 1, i+1);
        }
    }

    private static void spread(int[][] map) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (map[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;
                    q.add(new int[] {i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        int r = cur[0];
                        int c = cur[1];

                        for (int d=0; d<4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

                            if (!visited[nr][nc] && map[nr][nc]==0) {
                                map[nr][nc] = 2;
                                visited[nr][nc] = true;
                                q.add(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }


        int count = 0;
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (map[i][j]==0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }

    private static void print(int[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
