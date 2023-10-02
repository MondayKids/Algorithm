package baekjoon.backjoon10.day0110.day01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
연구소2
https://www.acmicpc.net/problem/17141

0 : 빈 칸
1 : 벽
2 : 바이러스 칸

바이러스 위치 개수 파악
바이러스 개수 중 m개를 선택
퍼뜨리는 시뮬레이션을 통해 최소 시간 구하기
퍼뜨릴 수 없는 경우 -1 을 출력


5 1
2 1 1 1 1
1 2 0 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1

-1

 */
public class B17141 {

    static int n, m;
    static int[][] board;
    static List<dot> virus;
    static int virusN;
    static int[] selectedVirus;

    static boolean[][] visited;

    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        virus = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 2) {
                    virus.add(new dot(i, j));
                }
            }
        }

        virusN = virus.size();
        selectedVirus = new int[m];
        answer = Integer.MAX_VALUE;

        // 바이러스 중 m개 선택
        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    // 바이러스 중 m개 선택
    public static void dfs(int stage, int start) {

        if(stage == m) {
            simulation();
            return;
        }

        for(int i = start; i < virusN; i++) {
            selectedVirus[stage] = i;
            dfs(stage+1, i+1);
        }
    }

    public static void simulation() {

        int[][] newBoard = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                newBoard[i][j] = board[i][j];
                if(board[i][j] == 2) {
                    newBoard[i][j] = 0;
                }
            }
        }

        Queue<searchDot> que = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            int virusy = virus.get(selectedVirus[i]).y;
            int virusx = virus.get(selectedVirus[i]).x;

            newBoard[virusy][virusx] = 2;
            que.add(new searchDot(virusy, virusx, 0));
            visited[virusy][virusx] = true;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        int result = 0;

        while (!que.isEmpty()) {
            searchDot d = que.poll();

            for(int i = 0; i < 4; i++) {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(check(ny,nx)) {
                    visited[ny][nx] = true;
                    newBoard[ny][nx] = 2;
                    que.add(new searchDot(ny,nx,d.count+1));
                    result = Math.max(result, d.count + 1);
                }
            }
        }


        if(spreadCheck(newBoard)) {
            answer = Math.min(answer, result);
        }
    }

    // 다 퍼젔는지 확인
    public static boolean spreadCheck(int[][] newBoard) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(newBoard[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < n && board[y][x] != 1 && visited[y][x] == false) {
            return true;
        }
        else {
            return false;
        }
    }

    public static class searchDot {
        int y;
        int x;
        int count;

        searchDot(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

    }






    public static class dot {
        int y;
        int x;

        dot(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
