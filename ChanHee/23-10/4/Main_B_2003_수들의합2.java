import java.util.Scanner;

// https://www.acmicpc.net/problem/2003
public class Main_B_2003_수들의합2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 숫자의 개수
        int M = sc.nextInt(); // 타겟

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        while (true) {
            if (sum >= M) {
                sum -= arr[left++];
            } else if (right == N) {
                break;
            } else {
                sum += arr[right++];
            }

            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}
