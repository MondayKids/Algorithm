import java.util.Scanner;

// https://www.acmicpc.net/problem/15652
public class Main_B_15652_N과M4 {

    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] numbers = new int[m];

        solve(0, numbers);
    }

    private static void solve(int index, int[] numbers) {
        if (index == m) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=n; i++) {
            if (index>0 && i < numbers[index - 1]) {
                continue;
            }
            numbers[index] = i;
            solve(index+1, numbers);
        }
    }
}
