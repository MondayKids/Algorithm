package BOJ;

import java.io.*;
import java.util.*;
public class Main_B_1062_가르침 {

    static int N, K, answer;
    static String[] words;
    static boolean[] selected;
    static boolean isAvailable;

    static void combination(int idx, int r) {
        if (r == 0) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                isAvailable = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!selected[words[i].charAt(j) - 'a']) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        for (int i = idx; i < 26; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            combination(i, r - 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        selected = new boolean[26];

        for (int i = 0; i < N; i++)
            words[i] = br.readLine().replace("anta", "").replace("tica", "");

        if (K < 5) System.out.println(0);
        else if (K == 26) System.out.println(N);
        else {
            answer = 0;
            String s = "antic";
            for (int i = 0; i < 5; i++) selected[s.charAt(i) - 'a'] = true;
            combination(0, K - 5);
            System.out.println(answer);
        }

        br.close();
    }
}
