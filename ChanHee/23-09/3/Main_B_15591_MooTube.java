import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/15591
public class Main_B_15591_MooTube {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 비디오 개수
        int Q = Integer.parseInt(st.nextToken()); // 질문 개수

        // 인접 리스트
        List<int[]>[] adjlist = new ArrayList[N + 1];

        // 초기화
        for (int i=0; i<=N; i++) {
            adjlist[i] = new ArrayList<>();
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            adjlist[p].add(new int[] {q, r});
            adjlist[q].add(new int[] {p, r});
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 기준 연관도 점수
            int v = Integer.parseInt(st.nextToken()); // 동영상

            boolean[] visited = new boolean[N + 1]; // 방문 배열
            Queue<Integer> q = new LinkedList<>();
            q.add(v);

            int ans = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                visited[cur] = true;

                for (int[] arr : adjlist[cur]) {
                    if (!visited[arr[0]] && arr[1] >= k) {
                        q.add(arr[0]);
                        visited[arr[0]] = true;
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
