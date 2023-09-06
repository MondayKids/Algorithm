import java.util.*;

// https://www.acmicpc.net/problem/2644
public class Main_B_2644_촌수계산 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 전체 사람의 수

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        int M = sc.nextInt(); // 관계의 개수 (간선의 수)

        List<Integer>[] adj = new ArrayList[N + 1];

        for (int i=0; i<=N; i++) {
            adj[i] = new ArrayList();
        }

        for (int i=0; i<M; i++) {
            int parent = sc.nextInt();
            int child  = sc.nextInt();

            adj[parent].add(child);
            adj[child].add(parent);
        }

        boolean[] visited = new boolean[N + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {p1, 0});
        visited[p1] = true;

        int ans = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int node = cur[0];
            int cnt  = cur[1];

            if (node == p2) {
                ans = cnt;
                break;
            }

//            for (int x : adj[node]) {
//                if (!visited[x]) {
//                    q.add(new int[] {x, cnt+1});
//                    visited[x] = true;
//                }
//            }

            adj[node].stream()
                    .filter(x -> !visited[x])
                    .forEach(x -> {
                        q.add(new int[] {x, cnt+1});
                        visited[x] = true;
                    });

        }

        System.out.println(ans);
    }
}
