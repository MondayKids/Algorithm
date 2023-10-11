import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3190
public class Main_B_3190_뱀 {

    // 하좌상우
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int N;
    static int K;
    static boolean[][] isApple;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Dir {
        int time;
        String d;

        public Dir(int time, String d) {
            this.time = time;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 지도의 크기
        K = Integer.parseInt(br.readLine()); // 사과의 개수

        isApple = new boolean[N+1][N+1]; // 사과 존재 여부

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            isApple[r][c] = true;
        }

        Deque<Node> snake = new LinkedList<>();
        snake.addLast(new Node(1, 1)); // 시작 위치 (1,1) 시작 방향  오른쪽


        int L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
        Deque<Dir> q = new LinkedList<>();
        for (int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 경과 시간
            String d = st.nextToken(); // D(오른쪽) or Left(왼쪽)
            q.add(new Dir(t, d));
        }

        int time = 0;
        int d = 3;
        // 게임이 끝날 때 까지 무한 반복
        loopA : while(!snake.isEmpty()) {
            time++;

            Node head = snake.peekLast(); // 머리

            // 방향에 따라 이동
            int nr = head.r + dr[d];
            int nc = head.c + dc[d];

            // 종료 조건
            if (nr<1 || nr>N || nc<1 || nc>N) {
                //System.out.println("종료 1");
                break;
            }
            for (Node data : snake) {
                if (data.r == nr && data.c == nc) { // 뱀의 몸에 부딪히는 경우
                    //System.out.println("종료 2");
                    break loopA;
                }
            }



            // 이동한 칸에 사과가 있다면?
            if (isApple[nr][nc]) {
                isApple[nr][nc] = false; // 사과 제거
                snake.addLast(new Node(nr, nc)); // 머리 추가
            } else { // 사과가 없다면?
                snake.addLast(new Node(nr, nc)); // 머리 추가
                snake.removeFirst();
            }

            // 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            if (!q.isEmpty()) {
                Dir currentDir = q.peekFirst();
                if (currentDir.time == time) { // 방향을 변화시켜줘야 하는 시점
                    q.poll();
                    if (currentDir.d.equals("L")) {
                        d = ((d-1) + 4) % 4;
                    } else if (currentDir.d.equals("D")) {
                        d = (d+1) % 4;
                    }
                }
            }
        }
        System.out.println(time);
    }
}
