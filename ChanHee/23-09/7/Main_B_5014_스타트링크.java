import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/5014
public class Main_B_5014_스타트링크 {

    static int F, S, G, U, D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt(); // Frame
        S = sc.nextInt(); // Start
        G = sc.nextInt(); // Goal
        U = sc.nextInt(); // Up
        D = sc.nextInt(); // Down

        boolean[] visited = new boolean[F + 1]; // 층수 방문 배열
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {S, 0});
        visited[S] = true;

        int ans = -999;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int n = cur[0];
            int cnt = cur[1];

            if (n == G) {
                ans = cnt;
                break;
            }

            for (int i=0; i<2; i++) {

                int next = 0;

                if (i==0) {
                    next = n + U;
                } else {
                    next = n - D;
                }

                if (next<=0 || next>F) continue;

                if (!visited[next]) {
                    q.add(new int[] {next, cnt+1});
                    visited[next] = true;
                }
            }
        }

        if (ans == -999) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }
    }
}
