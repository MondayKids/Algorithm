/*
4 ^ 8  = 2 ^ 16
1024 10
2000 11
4000 12
8000 13
16000 14
32000 15
64000 16

64000가지 조회
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/15683
public class Main_B_15683_감시 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    static class CCTV {
        int r;
        int c;
        boolean[] visited;
        int type;

        public CCTV(int r, int c, boolean[] visited, int type) {
            this.r = r;
            this.c = c;
            this.visited = visited;
            this.type = type;
        }
    }

    static int debugCount = 0;
    static int N, M;
    static List<CCTV> list = new ArrayList<>();
    static int[] selected;
    static int MIN = Integer.MAX_VALUE; // 사각지대 최소 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<M; c++) {
                map[r][c] = st.nextToken().charAt(0);
                int x = Integer.parseInt(map[r][c]+"");

                if (x==1 || x==3 || x==4) {
                    list.add(new CCTV(r, c, new boolean[4], x));
                } else if (x==2) {
                    list.add(new CCTV(r, c, new boolean[2], x));
                } else if (x==5) {
                    list.add(new CCTV(r, c, new boolean[1], x));
                }
            }
        }

        selected = new int[list.size()];
        dfs(0, 0, map);
        //System.out.println(debugCount);
        System.out.println(MIN);
    } // main

    private static void dfs(int count, int start, char[][] map) {

        if (count == list.size()) {
            //System.out.println(Arrays.toString(selected));

            // 조합된 CCTV 방향으로 BFS 수행 -> 사각지대 개수 구하기
            MIN = Math.min(bfs(map, selected), MIN);
            debugCount++;
            return;
        }

        for (int i=start; i<list.size(); i++) {
            CCTV cur = list.get(i);
            boolean[] temp = cur.visited;

            for (int j=0; j<temp.length; j++) {
                if (!temp[j]) {
                    temp[j] = true;
                    selected[count] = j;
                    dfs(count+1, i+1, map);
                    temp[j] = false;
                }
            }
        }
    }

    // 사각지대 개수 구하기
    private static int bfs(char[][] ogMap, int[] selected) {
        char[][] map = new char[N][M];
        map = copy(ogMap, map);

        for (int i=0; i<list.size(); i++) {
            CCTV cctv = list.get(i);
            int dir = selected[i];

            if (cctv.type == 2) {
                if (dir == 0) { // 상하
                    moveUp(map, cctv.r, cctv.c);
                    moveDown(map, cctv.r, cctv.c);
                } else if (dir == 1) { // 좌우
                    moveLeft(map, cctv.r, cctv.c);
                    moveRight(map, cctv.r, cctv.c);
                }
            } else if (cctv.type == 1) {
                if (dir == 0) {
                    moveUp(map, cctv.r, cctv.c);
                } else if (dir == 1) {
                    moveDown(map, cctv.r, cctv.c);
                } else if (dir == 2) {
                    moveLeft(map, cctv.r, cctv.c);
                } else if (dir == 3) {
                    moveRight(map, cctv.r, cctv.c);
                }
            } else if (cctv.type == 3) {
                if (dir == 0) { // 상우
                    moveUp(map, cctv.r, cctv.c);
                    moveRight(map, cctv.r, cctv.c);
                } else if (dir == 1) { // 우하
                    moveRight(map, cctv.r, cctv.c);
                    moveDown(map, cctv.r, cctv.c);
                } else if (dir == 2) { // 좌하
                    moveLeft(map, cctv.r, cctv.c);
                    moveDown(map, cctv.r, cctv.c);
                } else if (dir == 3) { // 좌상
                    moveLeft(map, cctv.r, cctv.c);
                    moveUp(map, cctv.r, cctv.c);
                }
            } else if (cctv.type == 4) {
                if (dir == 0) { // 좌상우
                    moveLeft(map, cctv.r, cctv.c);
                    moveUp(map, cctv.r, cctv.c);
                    moveRight(map, cctv.r, cctv.c);
                } else if (dir == 1) { // 상우하
                    moveRight(map, cctv.r, cctv.c);
                    moveUp(map, cctv.r, cctv.c);
                    moveDown(map, cctv.r, cctv.c);
                } else if (dir == 2) { // 좌하우
                    moveLeft(map, cctv.r, cctv.c);
                    moveDown(map, cctv.r, cctv.c);
                    moveRight(map, cctv.r, cctv.c);
                } else if (dir == 3) { // 상좌하
                    moveLeft(map, cctv.r, cctv.c);
                    moveUp(map, cctv.r, cctv.c);
                    moveDown(map, cctv.r, cctv.c);
                }
            } else if (cctv.type == 5) {
                moveUp(map, cctv.r, cctv.c);
                moveDown(map, cctv.r, cctv.c);
                moveLeft(map, cctv.r, cctv.c);
                moveRight(map, cctv.r, cctv.c);
            }
        }

        return getZeroCount(map);
    }

    private static char[][] moveUp(char[][] map, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nr = cur[0] + dr[0];
            int nc = cur[1] + dc[0];

            if (!isPossible(nr, nc) || map[nr][nc] == '6') break;

            map[nr][nc] = '#';
            q.add(new int[] {nr, nc});
        }
        return map;
    }

    private static char[][] moveDown(char[][] map, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nr = cur[0] + dr[1];
            int nc = cur[1] + dc[1];

            if (!isPossible(nr, nc) || map[nr][nc] == '6') break;

            map[nr][nc] = '#';
            q.add(new int[] {nr, nc});
        }
        return map;
    }

    private static char[][] moveLeft(char[][] map, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nr = cur[0] + dr[2];
            int nc = cur[1] + dc[2];

            if (!isPossible(nr, nc) || map[nr][nc] == '6') break;

            map[nr][nc] = '#';
            q.add(new int[] {nr, nc});
        }
        return map;
    }

    private static char[][] moveRight(char[][] map, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nr = cur[0] + dr[3];
            int nc = cur[1] + dc[3];

            if (!isPossible(nr, nc) || map[nr][nc] == '6') break;

            map[nr][nc] = '#';
            q.add(new int[] {nr, nc});
        }
        return map;
    }

    // out of index check
    private static boolean isPossible(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static char[][] copy(char[][] map, char[][] newMap) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    // 사각지대 개수 구하기
    private static int getZeroCount(char[][] map) {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == '0') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 디버깅용
    private static void print(char[][] map) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
