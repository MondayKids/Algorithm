import java.util.Scanner;

// https://www.acmicpc.net/problem/2559
public class Main_B_2559_수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 숫자의 개수
        int K = sc.nextInt(); // 연속적인 날짜의 숫자

        // 누적합
        int[] arr = new int[N+1];
        for (int i=1; i<N+1; i++) {
            arr[i] = arr[i-1] + sc.nextInt();
        }

        int answer = Integer.MIN_VALUE;
        for (int i=K; i<=N; i++) {
            answer = Math.max(answer, arr[i] - arr[i-K]);
        }

        System.out.println(answer);
    }
}
