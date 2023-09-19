import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_B_14888_연산자끼워넣기 {

    static long max;
    static long min;
    static int N;
    static int[] numbers;
    static List<Character> operators;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = sc.nextInt();
        }
        operators = new ArrayList<>();
        for (int i=0; i<4; i++) {
            int temp = sc.nextInt();
            for (int j=0; j<temp; j++) {
                char x = 'a';
                switch(i) {
                    case 0:
                        x = '+';
                        break;
                    case 1:
                        x = '-';
                        break;
                    case 2:
                        x = '*';
                        break;
                    case 3:
                        x = '/';
                        break;
                }
                operators.add(x);
            }
        }
        visited = new boolean[operators.size()];

        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        solve(0, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void solve(int cnt, int sum) {
        if (cnt == operators.size()) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i=0; i< operators.size(); i++) {
            if (visited[i]) continue;

            char op = operators.get(i);
            int target = numbers[cnt+1];

            switch (op) {
                case '+':
                    visited[i] = true;
                    solve(cnt+1, sum+target);
                    visited[i] = false;
                    break;
                case '*':
                    visited[i] = true;
                    solve(cnt+1, sum*target);
                    visited[i] = false;
                    break;
                case '-':
                    visited[i] = true;
                    solve(cnt+1, sum-target);
                    visited[i] = false;
                    break;
                case '/':
                    visited[i] = true;
                    solve(cnt+1, sum/target);
                    visited[i] = false;
                    break;
            }

        }
    }
}
