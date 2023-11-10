import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15684
public class Main_B_15684_사다리조작 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M, H;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1; // 오른쪽
            map[a][b+1] = -1; // 왼쪽
        }

        // 사다리는 최대 3개 까지 설치 가능
        for (int i=0; i<=3; i++) {
            dfs(0, i);
        }

        System.out.println(-1);
    }

    static void dfs(int cnt, int dest) {
        // 지정한 사다리 개수만큼 설치한 경우
        if (cnt == dest) {
            // 사다리 타기 수행
            //print(map);
            //System.out.println();

            if (play()) {
                // 사다리타기에 성공한 경우 i -> i
                System.out.println(dest);
                System.exit(0);
            }
            return;
        }

        for (int i=1; i<=H; i++) {
            for (int j=1; j<N; j++) {
                if (map[i][j] != 0 || map[i][j+1] != 0) continue;

                map[i][j] = 1;
                map[i][j+1] = -1;
                dfs(cnt+1, dest);
                map[i][j] = 0;
                map[i][j+1] = 0;
            }
        }
    }

    static boolean play() {
        for (int i=1; i<=N; i++) {
            int cur_x = 1;
            int cur_y = i;

            // 바닥에 닿을 때 까지
            while (cur_x < H+1) {
                if (map[cur_x][cur_y] == 1) cur_y++;
                else if (map[cur_x][cur_y] == -1) cur_y--;
                cur_x++;
            }
            if (cur_y != i) return false;
        }
        return true;
    }

    static void print(int[][] map) {
        for (int i=1; i<=H; i++) {
            for (int j=1; j<=N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
