import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/21758
public class Main_B_21758_꿀따기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static long max = 0;
    static long[] input;
    static long[] leftSum;
    static long[] rightSum;
    static int N;
    static long total;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        leftSum = new long[N+1];
        rightSum = new long[N+1];
        input = new long[N+1];

        for (int i=1; i<N+1; i++) {
            input[i] = Long.parseLong((st.nextToken()));
        }

        for (int i=1; i<N+1; i++) {
            rightSum[i] = rightSum[i-1] + input[i];
        }

        for (int i=N; i>0; i--) {
            leftSum[i-1] = leftSum[i] + input[i];
        }

//        System.out.println(Arrays.toString(rightSum));
//        System.out.println(Arrays.toString(leftSum));


        total = rightSum[N];
        case1();
        case2();
        case3();


        System.out.println(max);
    }

    static void case1() {
        for (int i=2; i<=N; i++) {
            long bee1 = total - input[1] - input[i];
            long bee2 = total - rightSum[i];

            max = Math.max(max, bee1 + bee2);
        }
    }

    static void case2() {
        for (int i=N; i>1; i--) {
            long bee1 = total - input[N] - input[i-1];
            long bee2 = total - leftSum[i-2];

            max = Math.max(max, bee1 + bee2);
        }
    }

    static void case3() {
        for (int i=2; i<N; i++) {
            long bee1 = rightSum[i] - input[1];
            long bee2 = leftSum[i-1] - input[N];


            max = Math.max(max, bee1 + bee2);
        }
    }

}
