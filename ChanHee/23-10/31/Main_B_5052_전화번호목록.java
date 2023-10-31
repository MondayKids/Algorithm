import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5052
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] phone_number = new String[N]; // 전화번호 목록

            for (int j=0; j<N; j++) {
                phone_number[j] = br.readLine();
            }

            Arrays.sort(phone_number);

            if (isConsistent(N, phone_number)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);

    }

    private static boolean isConsistent(int N, String[] phone_number) {
        for (int i=1; i<N; i++) {
            if (phone_number[i].startsWith(phone_number[i-1])) {
                return false;
            }
        }

        return true;
    }
}
