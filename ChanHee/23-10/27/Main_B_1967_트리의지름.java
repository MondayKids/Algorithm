import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_B_1967_트리의지름 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 1000_000_000;

    static int N;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 노드의 개수
        list = new ArrayList[N+1]; // 그래프 표현 리스트 (양방향)

        // 리스트 초기화
        for (int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        // 그래프 입력
        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child  = Integer.parseInt(st.nextToken());
            int cost   = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, cost));
            list[child].add(new Node(parent, cost));
        }

        // 각 노드에서 최대 거리 탐색 (브루트포스 + DFS)
        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            visited[i] = true; // 시작 노드 방문 처리
            DFS(i, 0);
        }
        System.out.println(max);
    }

    static void DFS(int num, int cost) {
        for (Node node : list[num]) {
            if (!visited[node.end]) {
                visited[node.end] = true;
                DFS(node.end, cost + node.cost);
            }
        }

        // System.out.println("num: " + num + ", cost: " + cost);
        max = Math.max(max, cost); // 시작노드에서 갈 수 있는 모든 끝점의 거리 체크
    }
}

class Node {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}
