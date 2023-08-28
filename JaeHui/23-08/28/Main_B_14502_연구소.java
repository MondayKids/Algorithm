// https://www.acmicpc.net/problem/14502

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_B_14502_연구소 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, answer;
    static int[][] map;
    static int[][] copyMap;
    static List<Point> blank;
    static List<Point> virus;
    static Point[] walls;
    static Queue<Point> queue;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

    static void combination(int cnt, int idx) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = idx; i < blank.size(); i++) {
            walls[cnt] = new Point(blank.get(i).x, blank.get(i).y);
            combination(cnt + 1, i + 1);
        }
    }

    static void bfs() {
        for (int i = 0; i < N; i++)
            copyMap[i] = map[i].clone();
        for (int i = 0; i < 3; i++)
            copyMap[walls[i].y][walls[i].x] = 1;

        queue = new LinkedList<>();
        visited = new boolean[N][M];
        for (Point p: virus) {
            queue.add(p);
            visited[p.y][p.x] = true;
        }
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (copyMap[ny][nx] == 1 || visited[ny][nx]) continue;
                copyMap[ny][nx] = 2;
                visited[ny][nx] = true;
                queue.offer(new Point(nx, ny));
            }
        }

        count();
    }

    static void count() {
        int sum = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (copyMap[i][j] == 0) sum += 1;

        answer = Math.max(answer, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MIN_VALUE;
        map = new int[N][M];
        copyMap = new int[N][M];
        blank = new ArrayList<>();
        virus = new ArrayList<>();
        walls = new Point[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) blank.add(new Point(j, i));
                if (map[i][j] == 2) virus.add(new Point(j, i));
            }
        }

        combination(0, 0);
        System.out.println(answer);

        br.close();
    }
}
