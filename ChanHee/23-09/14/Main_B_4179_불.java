import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4179
public class Main_B_4179_불 {

    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};

    static int N;
    static int M;

    static class Jihoon {
        private int r;
        private int c;
        private int cnt;

        public Jihoon(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static class Fire {
        private int r;
        private int c;

        public Fire(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder   sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        boolean[][] visited1 = new boolean[N][M];
        boolean[][] visited2 = new boolean[N][M];

        Queue<Fire>   q1 = new LinkedList<>();
        Queue<Jihoon> q2 = new LinkedList<>();

        for (int i=0; i<N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                arr[i][j] = input[j];
                if (arr[i][j] == 'J') {
                    q2.add(new Jihoon(i, j, 1));
                    visited2[i][j] = true;
                }
                if (arr[i][j] == 'F') {
                    q1.add(new Fire(i, j));
                    visited1[i][j] = true;
                }
            }
        }

        // print_char(arr);

        loopA : while (true){

            Queue<Fire> temp1 = new LinkedList<>();
            while (!q1.isEmpty()) {
                Fire fire = q1.poll();
                // 불 확산
                int fr = fire.r;
                int fc = fire.c;
                for (int d = 0; d < 4; d++) {
                    int nfr = fr + dr[d];
                    int nfc = fc + dc[d];

                    if (nfr < 0 || nfr >= N || nfc < 0 || nfc >= M) continue;
                    if (arr[nfr][nfc] == '#') continue;
                    if (visited1[nfr][nfc]) continue;

                    arr[nfr][nfc] = 'F';
                    temp1.add(new Fire(nfr, nfc));
                    visited1[nfr][nfc] = true;
                }
            }

            q1.addAll(temp1);


            Queue<Jihoon> temp2 = new LinkedList<>();

            while (!q2.isEmpty()) {
                Jihoon jihoon = q2.poll();
                if (isEdge(jihoon.r, jihoon.c)) {
                    sb.append(jihoon.cnt);
                    break loopA;
                }

                int jr = jihoon.r;
                int jc = jihoon.c;
                for (int d = 0; d < 4; d++) {
                    int njr = jr + dr[d];
                    int njc = jc + dc[d];

                    if (njr < 0 || njr >= N || njc < 0 || njc >= M) continue;
                    if (visited2[njr][njc] || arr[njr][njc] == '#') continue;
                    if (visited1[njr][njc]) continue;

                    visited2[njr][njc] = true;
                    temp2.add(new Jihoon(njr, njc, jihoon.cnt + 1));
                }
            }

            q2.addAll(temp2);

            if(q2.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }



        System.out.println(sb.toString());
    }

    private static boolean isEdge(int r, int c) {
        return r == 0 || c == 0 || r == N - 1 || c == M - 1;
    }

    private static void print_char(char[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void print_boolean(boolean[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
4 6
######
......
#.J###
#F####

5 4
####
#...
#.##
#.J#
####

7 7
#######
#J#####
#.....#
#.#.#.#
#.#.#.#
F.#.#.#
##F.#.#

Q)
5 5
#F..#
#.J.#
###.#
###.#
###.#

A)
5
 */
