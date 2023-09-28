import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1759
public class Main_B_1759_암호만들기 {

    static int L;
    static int C;
    static char[] arr;
    static char[] input;
    static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[L];
        input = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);

        combination(0, 0);
    }

    private static void combination(int start, int cnt) {

        if (cnt == L) {
            boolean isMo = false;
            int isJa = 0;

            for (char x : arr) {
                if (set.contains(x)) {
                    isMo = true;
                } else {
                    isJa++;
                }
            }

            if (isMo && isJa>=2) {
                System.out.println(String.valueOf(arr));
            }

            return;
        }

        for (int i=start; i<C; i++) {
            arr[cnt] = input[i];
            combination(i+1, cnt+1);
        }
    }
}
