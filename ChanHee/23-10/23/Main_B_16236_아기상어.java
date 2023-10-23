/*
물고기 M마리 아기 상어 1마리

크기

조건
- 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸을 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.
- 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
- 크기가 같은 물고기는 먹을 수 없지만, 지나갈 수는 있다.

이동 위치 결정 방법
- 더 이상 먹을 수 있는 물고기가 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
- 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
- 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
    - 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값
    - 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

아기 상어는 이동과 동시에 물고기를 먹는다.
물고기를 먹으면, 그 칸은 빈 칸이 된다.

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
예) 크기가 2인 아기 상어는 물고기 2마리를 먹으면 크기가 3이 된다.

아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아 먹을 수 있는지 구하시오.

시작 (크기 : 2, 레벨 : 0)

4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4

1먹음 (크기 : 2, 레벨 : 1) -> 3칸 이동

4 3 2 9
0 0 0 0
0 0 0 0
1 2 3 4

1먹음 (크기 : 3, 레벨 : 0) -> 6칸 이동

4 3 2 0
0 0 0 0
0 0 0 0
9 2 3 4

2먹음 (크기 : 3, 레벨 : 1) -> 1칸 이동

4 3 2 0
0 0 0 0
0 0 0 0
0 9 3 4

2먹음 (크기 : 3, 레벨 : 2) -> 4칸 이동

4 3 9 0
0 0 0 0
0 0 0 0
0 0 3 4

엄마 상어 호출 -> 종료


풀이)
- 상어 클래스 (크기, 레벨)
- N * N 크기의 2차원 물고기 배열
- 물고기 클래스

아기 상어 위치에서 가장 가까운 거리의 물고기 찾는 함수 (2중 포문으로 왼쪽 좌표부터 돌기, 거리가 작을 경우 갱신)
물고기를 먹는 함수 (지도 갱신, 상어 상태 갱신)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/16236
public class Main_B_16236_아기상어 {

    static class Fish {
        int size;
        int row;
        int col;

        public Fish(int size, int row, int col) {
            this.size = size;
            this.row = row;
            this.col = col;
        }
    }
    static class Shark extends Fish{
        int size;
        int level;
        int row;
        int col;

        public Shark(int size, int level, int row, int col) {
            super(size, row, col);
            this.size = size;
            this.level = level;
            this.row = row;
            this.col = col;
        }
    }

    static int      N;      // 지도 크기
    static Fish[][] map;    // 지도
    static int      time;   // 경과 시간

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N       = Integer.parseInt(br.readLine()); // 지도 크기
        map     = new Fish[N][N]; // 지도
        time    = 0; // 경과 시간
        Shark shark = null;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 9) {
                    shark = new Shark(2, 0, i, j);
                } else if (input != 0) {
                    map[i][j] = new Fish(input, i, j);
                }
            }
        }

        /*
        아기 상어 위치에서 가장 가까운 거리의 물고기 찾는 함수 (2중 포문으로 왼쪽 좌표부터 돌기, 거리가 작을 경우 갱신)
        물고기를 먹는 함수 (지도 갱신, 상어 상태 갱신)
         */
        while (true) {
            // 최단 거리 물고기 리스트 조회
            Fish fish = getFish(shark);

            // 먹을 물고기 없음 -> 종료 (엄마 상어 호출)
            if (fish == null) {
                System.out.println(time); // 경과 시간 출력
                break;
            }

            // 물고기 먹고, 지도, 아기 상어 상태 업데이트
            eat(fish, shark);
        }
    } // main method

    /** 최단 거리 물고기 목록 조회 */
    private static Fish getFish(Shark shark) {
        List<Fish> targetList = new ArrayList<>();

        int min_distance = Integer.MAX_VALUE;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == null) continue;

                Fish fish = map[i][j];

                if ( !(fish instanceof Shark) ) {
                    if (fish.size < shark.size) {
                        int distance = getDistance(fish, shark);
                        if (distance == 998) continue;

                        if (distance < min_distance) {
                            targetList.clear();
                            targetList.add(fish);

                            min_distance = distance;
                        }
                        else if (distance == min_distance) {
                            targetList.add(fish);
                        }
                    }
                }
            }
        }

        if (targetList.size() == 0) {
            return null;
        }
        return targetList.get(0);
    }

    /** 물고기 먹기 */
    private static void eat(Fish fish, Shark shark) {
        map[fish.row][fish.col] = null; // 해당 칸 물고기 비우기

        int distance = getDistance(fish, shark);
        time += distance; // 경과 시간 업데이트

        // 상어 상태 업데이트
        shark.row = fish.row;
        shark.col = fish.col;

        shark.level++;

        if (shark.level == shark.size) {
            shark.size = shark.size+1; // 사이즈 1 증가
            shark.level = 0; // 레벨 0으로 초기화
        }
    }

    /** 물거기 - 상어 -> 거리 구하기 */
    private static int getDistance(Fish fish, Shark shark) {
        int sr = shark.row;
        int sc = shark.col;

        int gr = fish.row;
        int gc = fish.col;

        // BFS
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[N][N];
        q.add(new int[] {sr, sc});
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                visited[i][j] = 999;
            }
        }
        visited[sr][sc] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for (int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr<0 || nr>=N || nc<0 || nc>=N) continue;
                Fish f = map[nr][nc];
                if (f != null) {
                    if (shark.size < f.size) continue;
                }
                if (visited[nr][nc] <= visited[r][c] + 1) continue;
                visited[nr][nc] = visited[r][c] + 1;
                q.add(new int[] {nr, nc});
            }
        }

        return visited[gr][gc] - 1;
    }
} // Main Class
