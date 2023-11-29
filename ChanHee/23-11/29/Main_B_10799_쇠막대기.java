import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/10799
public class Main_B_10799_쇠막대기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] arr = br.readLine().toCharArray();

        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            char now = arr[i];

            if (now == '(') {
                stack.push('(');
                continue;
            }

            if (now == ')') {
                stack.pop();

                if (arr[i-1] == '(') { // 레이저
                    answer += stack.size();
                } else { // 쇠막대기 1개 분리
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
