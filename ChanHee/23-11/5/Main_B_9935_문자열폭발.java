/*
input : 100만

1번의 탐색에 작업을 완료해야한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/9935
public class Main_B_9935_문자열폭발 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] arr = br.readLine().toCharArray();
        char[] regex = br.readLine().toCharArray();

        Stack<Character> st = new Stack<>();

        for (char x : arr) {
            st.push(x);

            // 폭발 문자열과 길이가 같아지면 탐색 시작
            if (st.size() >= regex.length) {
                boolean flag = true;

                // st.size - regexSize 부터 ~ st.size까지 탐색
                for (int i=0; i<regex.length; i++) {
                    if (st.get(st.size() - regex.length + i) != regex[i])
                    {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int i=0; i<regex.length; i++) {
                        st.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());
    }
}
