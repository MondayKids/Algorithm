import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/16637
public class Main_B_16637_괄호추가하기 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, result;
    static char[] input;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        result = Integer.MIN_VALUE;

        // 2번 인덱스의 숫자부터 괄호를 치는 경우, 안치는 경우
        solve(2, input[0] - '0');
        System.out.println(result);
    }

    private static void solve(int i, int sum) {
        // 종료 조건
        if (i>=N) {
            result = Math.max(result, sum);
            return;
        }

        // 괄호를 안 친 경우
        solve(i + 2, cal(sum, input[i] - '0', input[i - 1]));

        // 괄호를 친 경우
        if (i+2 < N) {
            int right = cal(input[i] - '0', input[i + 2] - '0', input[i + 1]);
            int left = cal(sum, right, input[i - 1]);
            solve(i + 4, left);
        }
    }


    private static int cal(int a, int b, char op) {
        if (op == '+') return a+b;
        else if (op == '-') return a-b;
        else return a*b;
    }
}
