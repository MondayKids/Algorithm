package BOJ;

import java.io.*;
import java.util.*;

public class Main_B_2470_두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        long[] answer = new long[2];
        long min = Long.MAX_VALUE;
        long sum;

        while(left < right) {
            sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if (sum < 0) left++;
            else right--;
        }
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb);
        br.close();
    }
}
