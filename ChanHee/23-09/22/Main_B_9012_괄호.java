import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class Main_B_9012_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            if (isVPS(input)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isVPS(String data) {

        Stack<Character> stack = new Stack<>();

        char[] arr = data.toCharArray();

        for (char cur : arr) {

            if ( !(cur=='(' || cur==')') ) continue;

            // 체크
            if (stack.isEmpty()) {
                stack.add(cur);
            } else {
                char top = stack.peek();

                if (top=='(' && cur==')') {
                    stack.pop();
                } else {
                    stack.add(cur);
                }
            }
        }

        return stack.isEmpty();
    }
}
