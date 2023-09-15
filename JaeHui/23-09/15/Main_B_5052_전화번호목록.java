package BOJ;

import java.io.*;
import java.util.*;

public class Main_B_5052_전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        String[] numbers;
        Boolean isConsistent;

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            numbers = new String[N];
            for (int i = 0; i < N; i++) numbers[i] = br.readLine();

            Arrays.sort(numbers);

            isConsistent = true;
            for (int i = 1; i < N; i++)
                if (numbers[i].startsWith(numbers[i - 1])) { isConsistent = false; break; }

            if (isConsistent) System.out.println("YES");
            else System.out.println("NO");
        }

        br.close();
    }
}
