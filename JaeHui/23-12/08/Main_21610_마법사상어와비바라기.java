package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기 {

    static class Point {
        int r, c;

        Point (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }, dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Point> clouds = new ArrayList<>(); // 구름
        // 비바라기 실행
        for (int i = N - 2; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                clouds.add(new Point(i, j));
            }
        }

        boolean[][] visited;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            visited = new boolean[N][N];
            moveClouds(N, clouds, d, s);
            raining(map, visited, clouds);
            copyMagic(N, map, clouds);
            clouds = new ArrayList<>();
            generateClouds(N, map, visited, clouds);
        }

        System.out.println(getAnswer(N, map));
        br.close();
    }

    static void moveClouds(int N, ArrayList<Point> clouds, int d, int s) {
        for (Point cloud : clouds) {
            cloud.r += dr[d] * (s % N);
            cloud.c += dc[d] * (s % N);

            if (cloud.r >= N) cloud.r -= N;
            else if (cloud.r < 0) cloud.r += N;
            if (cloud.c >= N) cloud.c -= N;
            else if (cloud.c < 0) cloud.c += N;
        }
    }

    static void raining(int[][] map, boolean[][] visited, ArrayList<Point> clouds) {
        for (Point cloud: clouds) {
            if (cloud.r == -2) {
                System.out.println(cloud.r + " " + cloud.c);
            }
            map[cloud.r][cloud.c] += 1;
            visited[cloud.r][cloud.c] = true;
        }
    }

    static void copyMagic(int N, int[][] map, ArrayList<Point> clouds) {
        int nr, nc;
        for (Point cloud: clouds) {
            for (int d = 2; d <= 8; d += 2) {
                nr = cloud.r + dr[d];
                nc = cloud.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] <= 0) continue;
                map[cloud.r][cloud.c] += 1;
            }
        }
    }

    static void generateClouds(int N, int[][] map, boolean[][] visited, ArrayList<Point> clouds) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < 2 || visited[i][j]) continue;
                map[i][j] -= 2;
                clouds.add(new Point(i, j));
            }
        }
    }

    static int getAnswer(int N, int[][] map) {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += map[i][j];
            }
        }
        return answer;
    }
}
