package BOJ;

import java.io.*;
import java.util.*;

public class Main_B_16928_뱀과사다리게임 {

    static class Player {
        int n;
        int cnt;

        Player(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    static int bfs(Map<Integer, Integer> map) {
        boolean[] visited = new boolean[101];
        Queue<Player> queue = new LinkedList<>();
        visited[1] = true;
        queue.offer(new Player(1, 0));

        while (!queue.isEmpty()) {
            Player cur = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = cur.n + i;
                if (next == 100) return cur.cnt + 1;

                if (visited[next] || next > 100) continue;
                visited[next] = true;
                if (map.containsKey(next)) next = map.get(next);

                queue.add(new Player(next, cur.cnt + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int key, value;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            key = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            key = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }

        System.out.println(bfs(map));
        br.close();
    }
}
