import java.util.Arrays;
import java.util.Scanner;

/**
 * 체스판의 상태를 기록해야 함 -> 배열
 * ex) 4 * 4 size
 * 1,1 퀸이 놓여있음 : [1, 0, 0, 0] 1행 1열
 * 1,3 퀸이 놓여있음 : [3, 0, 0, 0] 1행 3열
 */

// https://www.acmicpc.net/problem/9663
public class Main_B_9663_N_Queen {

    static int N;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N+1];
        arr[0] = -999;

        cnt = 0;

        solve(1);
        System.out.println(cnt);

    }

    private static void solve(int row) {
        if (row == N+1) {
            cnt++;
            // System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i=1; i<=N; i++) {
            if (row<0 || row>N) continue;
            if (!isValid(row, i)) continue;

            arr[row] = i;
            solve(row+1);
            arr[row] = 0;
        }

    }

    private static boolean isValid(int row, int col) {

        // 세로, 대각선 검사
        for (int i=1; i<=N; i++) {
            if (arr[i] == col) {
                return false;
            }

            if (arr[i] != 0 && Math.abs(i - row) == Math.abs(arr[i] - col)) {
                return false;
            }
        }

        return true;
    }
}
