import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1697
public class Main_B_1697_숨바꼭질 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수빈이 위치
        int K = sc.nextInt(); // 동생 위치

        solve(N, K);
    }

    private static void solve(int N, int K) {

        boolean[] visited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {N, 0});
        visited[N] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int n = cur[0];
            int cnt = cur[1];

            if (n == K) {
                System.out.print(cnt);
                return;
            }

            for (int i=0; i<3; i++) {
                int nn = 0;
                if (i==0) {
                    nn = n - 1;
                } else if (i==1) {
                    nn = n + 1;
                } else {
                    nn = n * 2;
                }

                if (nn < 0 || nn > 100000) continue;
                if (visited[nn]) continue;
                q.add(new int[] {nn, cnt+1});
                visited[nn] = true;
            }
        }
    }
}
