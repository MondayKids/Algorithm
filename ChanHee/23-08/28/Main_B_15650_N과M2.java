package baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15650
public class Main_B_15650_N과M2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 숫자
        int M = sc.nextInt(); // 자리수

        int[] numbers = new int[M];
        StringBuilder sb = new StringBuilder();

        solve(N, M, 0, 0, numbers, sb);
        System.out.println(sb);
    }

    private static void solve(int n, int m, int index, int start, int[] numbers, StringBuilder sb) {
        if (index == m) {
            for (int number : numbers) {
                sb.append(number)
                        .append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }

        for (int i=start; i<n; i++) {
            numbers[index] = i+1;
            solve(n, m, index+1, i+1, numbers, sb);
        }
    }
}
