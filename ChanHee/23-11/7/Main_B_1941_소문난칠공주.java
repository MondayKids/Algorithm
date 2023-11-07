/*
25 C 7 = 480700 -> 구성된 집합이 유효한지 체크 (이다솜파 4명 이상, 7자리 서로 인접한지)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/1941
public class Main_B_1941_소문난칠공주 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int debug_cnt = 0;
    static ArrayList<int[]> list;
    static char[][] arr;
    static int[] selected;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        list = new ArrayList<>();
        arr = new char[5][5];
        selected = new int[7];

        for (int i=0; i<5; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j=0; j<5; j++) {
                arr[i][j] = input[j];
                list.add(new int[] {i, j});
            }
        }


        combination(0, 0);
//        System.out.println(debug_cnt); // 디버깅
        System.out.println(answer);
    }

    private static void combination(int depth, int start) {
        if (depth == 7) {
            debug_cnt++; // 조합 개수 디버깅용

            // selected가 유효한지 체크
            boolean[][] visited = new boolean[5][5];
            for (int idx : selected) {
                int[] cur = list.get(idx);
                int r = cur[0];
                int c = cur[1];

                visited[r][c] = true; // 방문 처리
            }
            // 7개가 연결되어있는지 체크
            if (check(visited)) {
                answer++;
            }

            return;
        }

        for (int i=start; i<25; i++) {
            selected[depth] = i;
            combination(depth+1, i+1);
            selected[depth] = 0;
        }
    }

    private static boolean check(boolean[][] visited) {
        int[] dr = {-1, 1, 0 ,0};
        int[] dc = {0, 0, -1, 1};

        boolean[][] checked = new boolean[5][5];
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (visited[i][j] && !checked[i][j]) { // 몇 개가 이어져있는지 조사
                    int cnt = 1;
                    int pa = 0;
                    if (arr[i][j] == 'Y') pa++;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    checked[i][j] = true;

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];

                        for (int d=0; d<4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr<0 || nr>=5 || nc<0 || nc>=5) continue;
                            if (!visited[nr][nc]) continue;
                            if (checked[nr][nc]) continue;

                            checked[nr][nc] = true;
                            q.add(new int[] {nr, nc});
                            if (arr[nr][nc] == 'Y') pa++;
                            if (pa >= 4) return false;
                            cnt++;
                        }
                    }

                    if (cnt != 7) return false;
                }
            }
        }
        return true;
    }

    // 디버깅용
    private static void print(boolean[][] arr) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
