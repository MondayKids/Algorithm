import java.util.Scanner;

// https://www.acmicpc.net/problem/1182
public class Main_B_1182_부분수열의합 {

    static int N;
    static int Goal;
    static int[] input;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Goal = sc.nextInt();

        input = new int[N];
        for (int i=0; i<N; i++) {
            input[i] = sc.nextInt();
        }

        combination(0, 0);
        System.out.println(Goal == 0 ? ans-1 : ans);
    }

    private static void combination(int cnt, int sum) {
        if (cnt == N) {
            if (sum == Goal) {
                ans++;
            }
            return;
        }

        combination(cnt+1, sum+input[cnt]);
        combination(cnt+1, sum);
    }
}
