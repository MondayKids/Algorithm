import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// https://www.acmicpc.net/problem/5430
public class Main_B_5430_AC {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        StringBuilder sb = new StringBuilder();
        A : for (int t=1; t<=T; t++) { // 테스트 케이스 반복
            char[] cmd_arr = br.readLine().toCharArray(); // 명령 배열
            int n = Integer.parseInt(br.readLine()); // 정수의 개수

            Deque<Integer> deque = new ArrayDeque<>();
            boolean flag = true;
            if (n == 0) {
                br.readLine();
                for (char cmd : cmd_arr) {
                    if (cmd == 'D') {
                        sb.append("error").append("\n");
                        continue A;
                    }
                }
                sb.append("[]").append("\n");
                continue A;
            } else {
                String[] input = intputProcess(br.readLine());

                for (String number : input) {
                    deque.add(Integer.parseInt(number));
                }

                // flag
                // true -> 왼쪽
                // flase -> 오른쪽
                for (char cmd : cmd_arr) {
                    if (cmd == 'R') flag = !flag;
                    if (cmd == 'D' && deque.size()==0) {
                        sb.append("error").append("\n");
                        continue A;
                    }

                    if (cmd == 'D') {
                        if (flag) { // 왼쪽
                            deque.removeFirst();
                        } else { // 오른쪽
                            deque.removeLast();
                        }
                    }
                }
            }
            sb.append("[");
            if (flag) {
                while (!deque.isEmpty()) {
                    int number = deque.removeFirst();
                    sb.append(number + ",");
                }
            } else {
                while (!deque.isEmpty()) {
                    int number = deque.removeLast();
                    sb.append(number + ",");
                }
            }
            if (sb.charAt(sb.length()-1) == ',') sb.deleteCharAt(sb.length()-1);
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }

    private static String[] intputProcess(String input) {
        input = input.replace("[", "");
        input = input.replace("]", "");
        String[] x = input.split(",");
        return x;
    }
}
