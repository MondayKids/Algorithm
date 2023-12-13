import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * M : 3
 * 1 2 3 1 2 (input)
 * 1 3 6 7 9 (누적 합)
 * 1 0 0 1 0 (누적 합 % M)
 */

// https://www.acmicpc.net/problem/10986
public class Main_B_10986_나머지합 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long result = 0;

        long[] S = new long[N+1]; // 합 배열
        long[] cnt = new long[M]; // 같은 나머지의 인덱스를 카운트하는 배열

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            S[i] = (S[i-1] + Integer.parseInt(st.nextToken())) % M;
            if (S[i] == 0) result++;
            cnt[(int) S[i]]++; // 나머지가 같은 인덱스의 수 카운팅
        }

        for (int i=0; i<M; i++) {
            if (cnt[i] > 1) result += (cnt[i] * (cnt[i]-1) / 2);
        }
        System.out.println(result);
    }
}
