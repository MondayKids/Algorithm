package BOJ;

import java.io.*;
import java.util.*;

public class Main_B_1253_좋다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int left, right;
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            left = 0;
            right = N - 1;
            while(true) {
                if (left == i) left++;
                else if (right == i) right--;

                if (left >= right) break;

                if (nums[left] + nums[right] > nums[i]) right--;
                else if (nums[left] + nums[right] < nums[i]) left++;
                else { answer++; break; }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
