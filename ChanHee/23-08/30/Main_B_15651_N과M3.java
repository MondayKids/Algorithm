import java.util.Scanner;

// https://www.acmicpc.net/problem/15651
public class Main_B_15651_N과M3 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[M];

        solve(N, M, numbers, 0);
        System.out.println(sb.toString());
    }

    private static void solve(int n, int m, int[] numbers, int index) {
        if (index == m) { // 기저 조건
            for (int number : numbers) {
                sb.append(number)
                        .append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }

        for (int i=1; i<=n; i++) { // 재귀 조건
            numbers[index] = i;
            solve(n, m, numbers, index+1);
        }
    }
}
