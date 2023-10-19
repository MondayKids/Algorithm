/*
N : 동굴의 길이 (짝수) 20만
H : 동굴의 높이       50만

석순 - 종유석 (반복)

파괴해야 하는 장애물 최솟값 구하기 (브루트포스 + 이분탐색)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3020
public class Main_B_3020_개똥벌레 {

    static int N, H; // 길이, 높이

    static int[] down;
    static int[] up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);

        // 홀수 : down
        // 짝수 : up
        down = new int[N/2];
        up   = new int[N/2];
        for (int i=0; i<N; i++) {
            if (i%2==0) {
                down[i/2] = Integer.parseInt(br.readLine());
            } else {
                up[i/2] = Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = N;
        int cnt = 0;

        for (int i=1; i<H+1; i++) {
            int conflict = binarySearch(i, down) + binarySearch(H-i+1, up);

            if (min == conflict) {
                cnt++;
                continue;
            }

            if (min > conflict) {
                min = conflict;
                cnt = 1;
            }
        }

        System.out.println(min + " " + cnt);
    }

    static int binarySearch(int h, int[] arr) {
        int left = 0;
        int right = N/2;
        while (left < right) {
            int mid = (left+right) / 2;

            if (arr[mid] >= h) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return arr.length - right;
    }
}
