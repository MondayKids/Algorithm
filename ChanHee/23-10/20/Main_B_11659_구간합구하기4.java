import java.util.Scanner;

// https://www.acmicpc.net/problem/11659
public class Main_B_11659_구간합구하기4 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sum = new int[N+1];
        sum[1] = arr[0]; // 0 5 0 0 0 0
        for (int i=2; i<=N; i++) {
            sum[i] = arr[i-1] + sum[i-1];
        }

        for (int i=0; i<M; i++) {
            int a = sc.nextInt() -1;
            int b = sc.nextInt();

            sb.append(sum[b] - sum[a]).append("\n");
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
