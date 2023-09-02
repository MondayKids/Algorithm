import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 인접 리스트 사용
// https://www.acmicpc.net/problem/1260
public class Main_B_1260_DFS와BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int vertex = Integer.parseInt(st.nextToken());
        int edge   = Integer.parseInt(st.nextToken());
        int start  = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[vertex + 1];

        ArrayList<Integer>[] adjlist = new ArrayList[vertex + 1];
        for (int i=0; i<adjlist.length; i++) {
            adjlist[i] = new ArrayList<>();
        }

        for (int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            adjlist[a1].add(a2);
            adjlist[a2].add(a1);
        }

        for (ArrayList<Integer> list : adjlist){
            Collections.sort(list);
        }

        dfs(adjlist, visited, start);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(adjlist, visited, start);
    }

    private static void dfs(ArrayList<Integer>[] adjlist, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int e : adjlist[v]) {
            if (!visited[e]) {
                dfs(adjlist, visited, e);
            }
        }
    }

    private static void bfs(ArrayList<Integer>[] adjlist, boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for (int e : adjlist[v]) {
                if (!visited[e]) {
                    q.add(e);
                    visited[e] = true;
                }
            }
        }
    }

}
