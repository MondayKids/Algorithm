import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10974
public class Main_B_10974_모든순열 {

    static int N;
    static int[] seleted;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        seleted = new int[N];
        visited = new boolean[N+1];

        solve(0);
        System.out.println(sb.toString());
    }

    private static void solve(int cnt) {
        if (cnt == N) {
            for (int x : seleted) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seleted[cnt] = i;
                solve(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
