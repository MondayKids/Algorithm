package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_B_5430_AC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char[] commands;
        int N;
        Deque<Integer> deque;
        boolean isError, isReverse;

        for (int t = 0; t < T; t++) {
            commands = br.readLine().toCharArray();
            N = Integer.parseInt(br.readLine());
            deque = new LinkedList<>();
            st = new StringTokenizer(br.readLine().replace("[", "").replace("]", ""), ",");
            for (int i = 0; i < N; i++) deque.add(Integer.parseInt(st.nextToken()));
            isReverse = false; isError = false;

            for (char command: commands) {
                switch (command) {
                    case 'R':
                        isReverse = !isReverse;
                        break;
                    case 'D':
                        if (deque.isEmpty()) { isError = true; break; }
                        if (isReverse) deque.removeLast();
                        else deque.removeFirst();
                        break;
                }
            }
            if (isError) sb.append("error\n");
            else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReverse ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
