package baekjoon.backjoon9.day2;

import java.util.*;
import java.lang.*;
import java.io.*;



public class B16932 {

    static int n;
    static int m;
    static int[][] board;

    static Queue<dot> zeroQue;
    static Map<Integer, Integer> areaMap;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        zeroQue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) {
                    zeroQue.add(new dot(i, j));
                }
            }
        }

        // 영역의 넓이를 구하고 인덱싱 하기
        areaMap = new HashMap<>();
        findArea();

        // zeroQue 에서 0인 것을 꺼내 4방향을 탐색에 연결했을 때 가장 큰 영역을 answer에 계속 업데이트 한다.
        findAnswer();

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);


    }


    public static void findAnswer() {

        while (!zeroQue.isEmpty()) {
            int result = 1;
            dot d = zeroQue.poll();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (board[ny][nx] != 0) {
                        set.add(board[ny][nx]);
                    }
                }
            }

            for (int index : set) {
                result += areaMap.get(index);
            }

            answer = Math.max(answer, result);

        }

    }


    public static void findArea() {
        visited = new boolean[n][m];
        int index = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 1 && visited[i][j] == false) {
                    index += 1;
                    int area = calculateArea(i, j, index);
                    areaMap.put(index, area);
                }
            }
        }
    }

    public static int calculateArea(int y, int x, int index) {
        visited[y][x] = true;
        Queue<dot> que = new LinkedList<>();
        que.add(new dot(y, x));
        int area = 1;
        board[y][x] = index;

        while (!que.isEmpty()) {
            dot d = que.poll();

            for (int i = 0; i < 4; i++) {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(check(ny, nx)) {
                    visited[ny][nx] = true;
                    board[ny][nx] = index;
                    que.add(new dot(ny, nx));
                    area += 1;
                }
            }

        }

        return area;

    }

    // 범위 안에 있고 1인 경우
    // true : 탐색 가능, false : 탐색 불가능
    public static boolean check(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < m && board[y][x] == 1) {
            return true;
        }
        return false;
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
