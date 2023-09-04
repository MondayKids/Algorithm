import java.util.*;

// https://www.acmicpc.net/problem/2606
public class Main_B_2606_바이러스 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();

        List<Integer>[] adj = new ArrayList[N + 1];

        for (int i=0; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=1; i<=P; i++) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();

            adj[a1].add(a2);
            adj[a2].add(a1);
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int com : adj[cur]) {
                if (!visited[com]) {
                    q.add(com);
                    visited[com] = true;
                    ans++;
                }
            }
        }

        if (ans > 1) {
            System.out.println(ans - 1);
        } else {
            System.out.println(0);
        }
    }

}
