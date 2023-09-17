import java.util.Scanner;

// https://www.acmicpc.net/problem/1065
public class Main_B_1065_한수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 0;
        for (int i=1; i<=N; i++) {
            if (solve(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean solve(int n) {
        String sn = n + "";

        if (sn.length() <= 2) {
            return true;
        }

        char[] arr = sn.toCharArray();
        int pre = Integer.parseInt(arr[0] + "");
        int diff = Integer.parseInt(arr[1] + "") - pre;

        for (int i=1; i<=sn.length() - 1; i++) {
            String sc = arr[i] + "";
            int cur = Integer.parseInt(sc);
            int cur_diff = cur - pre;

            if (diff != cur_diff) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}
