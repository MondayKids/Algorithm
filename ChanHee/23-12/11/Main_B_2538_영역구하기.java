import java.util.*;

// https://www.acmicpc.net/problem/2583
public class Main_B_2538_영역구하기 {

    static int N, M, K;
    static int[][] map; // 시계방향 90도 회전
    static boolean[][] visited;
    static int count;
    static ArrayList<Integer> q = new ArrayList<>(); // 분리된 영역 큐

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0 ,-1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt(); // 열
        N = sc.nextInt(); // 행
        K = sc.nextInt(); // 직사각형 개수

        map = new int[N][M];

        for (int i=0; i<K; i++) {
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            // (r1, c1) - (r2, c2) 직사각형 색칠하기
            paint(r1, c1, r2, c2);
        }

        // DFS (모든 좌표 순회하면서 분리된 영역 개수 구하기)
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                // 도형이 아니고, 방문 안한 경우만 탐색
                if (!visited[i][j] && map[i][j]==0) {
                    count = 1;
                    visited[i][j] = true;
                    dfs(i, j);
                    q.add(count);
                }
            }
        }

        System.out.println(q.size());
        Collections.sort(q); // 오름차순 정렬
        for (int x : q) {
            System.out.print(x + " ");
        }
    }

    static void paint(int r1, int c1, int r2, int c2) {
        for (int i=r1; i<r2; i++) {
            for (int j=c1; j<c2; j++) {
                map[i][j] = 1;
            }
        }
    }

    static void dfs(int r, int c) {

        for (int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
            if (map[nr][nc] == 1) continue;
            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                count++;
                dfs(nr, nc);
            }
        }
    }

    static void print(int[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
