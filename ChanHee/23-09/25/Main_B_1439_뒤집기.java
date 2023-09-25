import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1439
public class Main_B_1439_뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;
        boolean zeroFlag = false;
        boolean oneFlag = false;

        char[] arr = input.toCharArray();

        for (char x : arr) {
            if (zeroFlag == false && x=='0') {
                zeroCnt++;
                zeroFlag = true;
                oneFlag = false;
            } else if (oneFlag == false && x=='1') {
                oneCnt++;
                oneFlag = true;
                zeroFlag = false;
            }
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}
