import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/1987
public class Main_B_1987_알파벳 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int max = 0;
    static Set<Character> set = new HashSet<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 행
        M = Integer.parseInt(input[1]); // 열

        map = new char[N][M];
        visited = new boolean[N][M];

        // input
        for (int i=0; i<N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                map[i][j] = temp[j];
            }
        }

        // dfs
        visited[0][0] = true;
        set.add(map[0][0]);
        dfs(0, 0, 1); // 행 열 개수
        System.out.println(max);

    }

    private static void dfs(int r, int c, int cnt) {

        max = Math.max(max, cnt);

        for (int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
            if (visited[nr][nc]) continue;
            // 방문했던 알파뱃이면 무시
            if (set.contains(map[nr][nc])) continue;

            set.add(map[nr][nc]);
            dfs(nr, nc, cnt+1);
            set.remove(map[nr][nc]);
        }
    }
}
