import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1120
public class Main_B_1120_문자열 {

    static int MIN = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        String A = arr[0];
        String B = arr[1];

        int L = B.length() - A.length();

        for (int i=0; i<=L; i++) {
            diff(A, B.substring(i, A.length()+i));
        }

        System.out.println(MIN);
    }

    private static void diff(String A, String B) {
        char[] A1 = A.toCharArray();
        char[] B1 = B.toCharArray();

        int count = 0;
        for (int i=0; i<A1.length; i++) {
            if (A1[i] != B1[i]) count++;
        }

        MIN = Math.min(count, MIN);
    }
}
