package BOJ;

import java.io.*;
import java.util.*;

public class Main_B_2473_세용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        long[] answer = new long[3];
        long min = Long.MAX_VALUE;
        int left = 0;
        int right = N - 1;
        long sum;

        for (int i = 0; i < N - 2; i++) {
            left = i + 1;
            right = N - 1;

            while(left < right) {
                sum = arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }
                if (sum > 0) right--;
                else left++;
            }
        }

        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", answer[i]);
        br.close();
    }

}
