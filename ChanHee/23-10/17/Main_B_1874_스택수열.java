import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/1874
public class Main_B_1874_스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        int max = 0;
        Stack<Integer> stack = new Stack<>();

        int start = 1;
        for (int i=0; i<N; i++) {
            int input = sc.nextInt();

            for (int j=start; j<=input; j++) {
                if (j > max) {
                    stack.push(j);
                    start++;
                    sb.append("+").append("\n");
                }
            }

            if (stack.peek() == input) {
                max = Math.max(max, stack.pop());
                sb.append("-").append("\n");
            } else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb);
    }
}
