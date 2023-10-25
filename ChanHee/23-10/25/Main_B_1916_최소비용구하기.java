import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1916
public class Main_B_1916_최소비용구하기 {
    static class Node implements Comparable<Node>{
        int end;
        int weight;

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
    private static final int INF = 987654321;

    static int N, M;
    static int A, B;
    static int[] dist;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 도시의 개수 (정점)
        M = Integer.parseInt(br.readLine()); // 버스의 개수 (간선)

        dist = new int[N+1]; // 거리 기록 배열
        list = new ArrayList[N+1]; // 그래프 (인접 리스트)

        Arrays.fill(dist, INF); // 거리 배열 초기화
        for (int i=1; i<=N; i++) { // 그래프 초기화
            list[i] = new ArrayList<>();
        }

        // 버스의 개수만큼 반복
        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start  = Integer.parseInt(st.nextToken());
            int end    = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        // 시작도시, 종료도시
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        djikstra(A);

        System.out.println(dist[B]);
    }

    private static void djikstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue();
        boolean[] visited = new boolean[N+1];
        dist[start] = 0;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.end;

            if (visited[cur]) continue;
            visited[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
