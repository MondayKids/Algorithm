import java.util.Scanner;

// https://www.acmicpc.net/problem/10819
public class Main_B_10819_차이를최대로 {

    static int N;
    static int[] input;
    static int[] arr;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        input = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            input[i] = sc.nextInt();
        }

        // 중복 순열
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int cnt) {
        if (cnt == N) {
            // System.out.println(Arrays.toString(arr));

            int sum = 0;
            for (int i=0; i<N-1; i++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }

            max = Math.max(max, sum);
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = input[i];
                dfs(cnt+1);
                visited[i] = false;
            }
        }
    }
}
