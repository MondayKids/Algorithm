import java.util.Scanner;

// https://www.acmicpc.net/problem/2798
public class Main_B_2798_블랙잭 {

    static int N, M;
    static int min;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 카드 개수
        M = sc.nextInt(); // 목표 점수

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        min = 987654321;
        ans = 0;
        dfs(arr, 0, 0, 0);
        System.out.println(ans);

    }

    private static void dfs(int[] arr, int cnt, int start, int sum) {
        if (cnt == 3) {
            if (min > Math.abs(sum - M) && sum <= M) {
                ans = sum;
                min = Math.abs(sum - M);
            }
            return;
        }

        for (int i=start; i<N; i++) {
            dfs(arr, cnt+1, i+1, sum+arr[i]);
        }
    }
}
