package baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15649
public class Main_B_15649_N과M1 {

    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 숫자 범위
        int M = sc.nextInt(); // 길이
        int[] arr = new int[M]; // 출력 배열
        visited = new boolean[N+1]; // 방문 여부 체크 배열

        solve(N, M, 0, arr); // 요구 조건에 따른 출력 데이터 String Builder에 담기
        System.out.println(sb.toString()); // 정답 출력
    }

    // 요구 조건에 따른 출력 데이터 String Builder에 담기
    private static void solve(int N, int M, int depth, int[] arr) {
        if (depth == M) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++) {
            if (visited[i]) {
                continue;
            }
            arr[depth] = i;
            visited[i] = true;
            solve(N, M, depth+1, arr);
            visited[i] = false;
        }
    }
}
