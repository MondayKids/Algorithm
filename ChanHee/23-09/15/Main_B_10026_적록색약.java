import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/10026
public class Main_B_10026_적록색약 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static boolean[][] visited;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for (int i=0; i<N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                arr[i][j] = temp[j];
            }
        }

        visited = new boolean[N][N]; // B = 1  //  R,G = 2


        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;


        cnt = 0;
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j]=='R') {
                    arr[i][j] = 'G';
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(normal_cnt + " " + cnt);

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        char data = arr[r][c];
        for (int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr<0 || nr>=N || nc<0 || nc>=N) continue;

            if (!visited[nr][nc] && arr[nr][nc] == data) {
                dfs(nr, nc);
            }
        }
    }
}
