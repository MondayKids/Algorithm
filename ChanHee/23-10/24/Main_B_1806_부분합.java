/*
10만 * 10만 = 10000000000 = 100억
 */

import java.util.Scanner;

// https://www.acmicpc.net/problem/1806
public class Main_B_1806_부분합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] nums = new int[N + 1];
        for (int i=0; i<N; i++) {
            nums[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;

        while (start <= N && end <= N) {
            if (total >= S && min > end-start) min = end - start;

            if (total < S) total += nums[end++];
            else total -= nums[start++];
        }

        if (min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);


    }
}
