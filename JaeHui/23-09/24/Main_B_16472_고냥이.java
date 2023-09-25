package BOJ;

import java.io.*;
import java.util.*;

public class Main_B_16472_고냥이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int left, right, cnt, max = 1;
        Set<Character> set;

        for (left = 0; left < s.length(); left++) {
            right = left + 1;
            if (left > 0 && s.charAt(left) == s.charAt(left - 1)) continue;
            set = new HashSet<>(Arrays.asList(s.charAt(left)));
            cnt = 1;
            while (right < s.length()) {
                set.add(s.charAt(right));
                if (set.size() > N) break;
                right++;
                cnt++;
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
        br.close();
    }
}
