package baekjoon.backjoon10.day0110.day10;




import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
불!
https://www.acmicpc.net/problem/4179

가장 자리에서 탈출 할 수 있다.

지훈이는 4방향 중 한 방향
불은 4방향 확산
벽은 통과 못함

반례 모음
5 5
FFFFF
..J..
.....
.....
.....

4


3 3
.FF
..J
...

1


3 3
..F
.J#
.#.

2

 */
public class B4179 {

    static int r,c;
    static char[][] board;

    static boolean[][] visited;
    static Queue<dot> jihun;
    static Queue<dot> fire;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        jihun = new LinkedList<>();
        fire = new LinkedList<>();

        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);

                if(board[i][j] == 'J') {
                    jihun.add(new dot(i,j));
                    board[i][j] = '.';
                    visited[i][j] = true;
                }
                else if(board[i][j] == 'F') {
                    fire.add(new dot(i,j));
                }
            }
        }

        simulation();



    }

    public static void simulation() {

        // 불이 먼저 붙고 지훈이 이동

        int count = 0;
        boolean escape = false;


        while (!jihun.isEmpty()) {

            if (escape) {
                break;
            }

            Queue<dot> nextJihun = new LinkedList<>();
            Queue<dot> nextFire = new LinkedList<>();

            // 4방향으로 불이 번짐
            while (!fire.isEmpty()) {
                dot d = fire.poll();
                for(int i = 0; i < 4; i++) {
                    int ny = d.y + dy[i];
                    int nx = d.x + dx[i];

                    if(boardCheck(ny,nx)) {
                        board[ny][nx] = 'F';
                        nextFire.add(new dot(ny,nx));
                    }
                }
            }

            // 지훈이의 움직임
            while (!jihun.isEmpty()) {
                dot d = jihun.poll();
                for(int i = 0; i < 4; i++) {
                    int ny = d.y + dy[i];
                    int nx = d.x + dx[i];

                    // 경계로 탈출
                    if(ny == -1 || nx == -1 || ny == r || nx == c) {
                        escape = true;
                    }
                    else if(boardCheck(ny,nx) && visited[ny][nx] == false) {
                        visited[ny][nx] = true;
                        nextJihun.add(new dot(ny,nx));
                    }

                }
            }


            count += 1;

            fire = nextFire;
            jihun = nextJihun;

        }

        if(escape == false) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(count);
        }


    }


    public static boolean boardCheck(int y, int x) {
        if(y >= 0 && y < r && x >= 0 && x < c && board[y][x] == '.') {
            return true;
        }
        else {
            return false;
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
