import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15654
public class Main_B_15654_N과M5 {

    static int N;
    static int M;
    static int[] numbers;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        solve(0);
        System.out.println(sb.toString());
    }

    private static void solve(int index) {
        if (index == M) {
            for (int data : arr) {
                sb.append(data).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<numbers.length; i++) {
            int number = numbers[i];

            if (visited[i]) {
                continue;
            }

            arr[index] = number;
            visited[i] = true;
            solve(index+1);
            visited[i] = false;
        }
    }
}
