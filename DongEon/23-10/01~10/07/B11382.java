package baekjoon.backjoon10.day0110.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
꼬마 정민
https://www.acmicpc.net/problem/11382
 */
public class B11382 {

    public static void main(String[] args) throws IOException {
        long a, b, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        long result = a + b + c;
        System.out.println(result);
    }

}
