/*

다익스트라
배열 + 우선순위 큐 + BFS

정점, 간선
V,   E

시작 정점
K

a -> b (비용 : w)

ex)
5 -> 1 (1)
1 -> 2 (2)
1 -> 3 (3)
2 -> 3 (4)
2 -> 4 (5)
3 -> 4 (6)

1 -> 2 (2)
1 -> 3 (3)
1 -> 4
 */

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1753
public class Main_B_1753_최단경로 {
    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100_000_000; // 1억
    static int v, e, k;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, INF);

        for (int i=1; i<=v; i++) {
            list[i] = new ArrayList<>();
        }

        // 리스트에 그래프 정보를 초기화
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start에서 end로 가는 weight 가중치
            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();

        dijkstra(k);

        for (int i=1; i<=v; i++) {
            if (dist[i]==INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[v+1];
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (check[cur]) continue;
            check[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
