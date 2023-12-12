import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17144
public class Main_B_17144_미세먼지안녕 {

    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};

    static int N, M, T;
    static int[][] map;
    static List<int[]> AC = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) AC.add(new int[] {i, j});
            }
        }

        // T초 동안 공기청정기 가동
        for (int i=0; i<T; i++) {
            spread();
            purify();
        }

        // 남아있는 미세먼지 양 출력
        System.out.println(getSum());
    }

    static void spread() {
        int[][] map2 = new int[N][M]; // 누적 미세먼지 기록

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {

                    int spreadCount = 0;
                    int a = map[i][j] / 5; // 확산되는 미세먼지 양
                    // 4방향
                    for (int d=0; d<4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (nr<0 || nr>=N || nc<0 || nc>=M) continue;
                        if (map[nr][nc] == -1) continue;

                        map2[nr][nc] += a;
                        spreadCount++;
                    }
                    map[i][j] -= (a * spreadCount);
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] += map2[i][j];
            }
        }
    }

    static void purify() {
        antiClock();
        clock();
    }

    static void antiClock() {
        int[] cleaner1 = AC.get(0);
        int CR = cleaner1[0]; // 행

        // 왼쪽 정화
        for (int r=CR-1; r>0; r--) {
            map[r][0] = map[r-1][0];
        }

        // 위쪽 정화
        for (int c=0; c<M-1; c++) {
            map[0][c] = map[0][c + 1];
        }

        // 오른쪽 정화
        for (int r=0; r<CR; r++) {
            map[r][M - 1] = map[r+1][M - 1];
        }

        // 아래쪽 정화
        for (int c=M-1; c>1; c--) {
            map[CR][c] = map[CR][c - 1];
        }
        map[CR][1] = 0;
    }

    static void clock() {
        int[] cleaner2 = AC.get(1);
        int CR = cleaner2[0];

        // 왼쪽 정화
        for (int r=CR+1; r<N-1; r++) {
            map[r][0] =map[r+1][0];
        }

        // 아래쪽 정화
        for (int c=0; c<M-1; c++) {
            map[N - 1][c] = map[N - 1][c + 1];
        }

        // 오른쪽 정화
        for (int r=N-1; r>CR; r--) {
            map[r][M - 1] = map[r - 1][M - 1];
        }

        // 위쪽 정화
        for (int c=M-1; c>1; c--) {
            map[CR][c] = map[CR][c - 1];
        }
        map[CR][1] = 0;
    }

    static int getSum() {
        int sum = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] != -1) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }

    static void print(int[][] map) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
