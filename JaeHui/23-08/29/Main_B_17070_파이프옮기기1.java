package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_17070_파이프옮기기1 {

    static class Pipe {
        int x;
        int y;
        int d;

        Pipe(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int[][] dx = { { 1 }, { 0 }, { 1, 0, 1 }}, dy = { { 0 }, { 1 }, { 0, 1, 1 } }; // 0: 오른쪽 1: 아래 2: 오른쪽 아래 대각선
    static int[][] dn = { { 0, 2 }, { 1, 2 }, { 0, 1, 2 } }; // 0:가로 1:세로 2:대각선

    static int solution(int N, boolean[][] map) {
        int answer = 0;
        Queue<Pipe> queue = new LinkedList<>();
        queue.add(new Pipe(1, 0, 0));
        while(!queue.isEmpty()) {
            Pipe cur = queue.poll();
            for (int d = 0; d < dn[cur.d].length; d++) {
                int nx = cur.x;
                int ny = cur.y;
                boolean isAvailable = true;
                for (int i = 0; i < dx[dn[cur.d][d]].length; i++) {
                    nx = cur.x + dx[dn[cur.d][d]][i];
                    ny = cur.y + dy[dn[cur.d][d]][i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[ny][nx]) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable) {
                    if (nx == N - 1 && ny == N - 1) answer += 1;
                    else queue.offer(new Pipe(nx, ny, dn[cur.d][d]));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                if (st.nextToken().equals("1")) map[i][j] = true;
        }

        if (map[N - 1][N - 1]) System.out.println(0);
        else System.out.println(solution(N, map));

        br.close();
    }
}
