import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
N명의 인원을 반으로 나누는 모든 경우를 구한다.

최대 10명 -> 10! -> 2초내의 풀이 가능

 */

// https://www.acmicpc.net/problem/14889
public class Main_B_14889_스타트와링크 {

    static int[][] arr;
    static int N;

    static boolean[] visited;

    static int Min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];

        Min = Integer.MAX_VALUE;
        dfs(0,0);
        System.out.println(Min);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == N/2) {
            diff();
            return;
        }

        for (int i=idx; i<N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(i+1, cnt+1);
            visited[i] = false;
        }
    }

    private static void diff() {
        int teamA = 0;
        int teamB = 0;

        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {

//                System.out.println(i + " " + j);

                if (visited[i] && visited[j]) {
                    teamA += arr[i][j];
                    teamA += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamB += arr[i][j];
                    teamB += arr[j][i];
                }
            }
        }

        int diff = Math.abs(teamA - teamB);

        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }

        Min = Math.min(Min, diff);
    }
}
