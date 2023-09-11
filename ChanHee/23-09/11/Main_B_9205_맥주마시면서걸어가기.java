import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/9205
public class Main_B_9205_맥주마시면서걸어가기 {

    static List<int[]> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine()); // TEST CASE 개수

        for (int tc=1; tc<=TC; tc++)
        {
            int N = Integer.parseInt(br.readLine()); // 편의점 개수

            st = new StringTokenizer(br.readLine(), " ");
            int sr = Integer.parseInt(st.nextToken()); // 출발 행
            int sc = Integer.parseInt(st.nextToken()); // 출발 열

            list = new ArrayList<>();

            for (int i=0; i<N; i++) // 편의점 좌표 입력
            {
                st = new StringTokenizer(br.readLine(), " ");
                int pr = Integer.parseInt(st.nextToken());
                int pc = Integer.parseInt(st.nextToken());
                list.add(new int[] {pr, pc});
            }

            st = new StringTokenizer(br.readLine(), " ");
            int gr = Integer.parseInt(st.nextToken()); // 도착 행
            int gc = Integer.parseInt(st.nextToken()); // 도착 열
            list.add(new int[] {gr, gc});

            solve(sr, sc, gr, gc);
        }

        System.out.println(sb);

    }

    private static void solve(int sr, int sc, int gr, int gc) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[list.size()];
        q.add(new int[] {sr, sc});

        while (!q.isEmpty())
        {
            int[] cur = q.poll();
            int ar = cur[0];
            int ac = cur[1];

            for (int i=0; i< list.size(); i++)
            {
                int[] next = list.get(i);
                int br = next[0];
                int bc = next[1];

                if (!visited[i] && getCost(ar, ac, br, bc) <= 1000) {
                    q.add(new int[] {br, bc});
                    visited[i] = true;
                }
            }
        }

        // System.out.println(Arrays.toString(visited));
        if (visited[list.size() - 1]) {
            sb.append("happy");
        } else {
            sb.append("sad");
        }
        sb.append("\n");
    }

    private static int getCost(int ar, int ac, int br, int bc) {
        return Math.abs(ar - br) + Math.abs(ac - bc);
    }
}
