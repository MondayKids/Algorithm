package baekjoon;

/*
다각형의 면적
https://www.acmicpc.net/problem/2166

신발끈 공식을 활용해서 푸는 문제

1 | x1 x2 x3 ... xn |
2 | y1 y2 y3 ... yn |

1/2 * |(x1y2 + x2y3 + ... xn-1yn + xny1) - (x2y1 + x3y2 + ... + x1yn)|
위에서 아래로 왼쪽에서 오른쪽 대각선 전부 더함 - 위에서 아래로 오른쪽에서 왼쪽 대각선 전부 더함 의 절대값에 나누기 2를 한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2166 {

    static int n;
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[2][n];
        long y = 0;
        long x = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Long.parseLong(st.nextToken());
            x = Long.parseLong(st.nextToken());
            arr[0][i] = x;
            arr[1][i] = y;
        }

        // 신발끈 이론
        double answer = 0;
        double left = 0;
        double right = 0;

        for(int i = 0; i < n; i++) {
            if(i == n-1) {
                left += arr[0][i] * arr[1][0];
                right += arr[0][0] * arr[1][i];
            }
            else {
                left += arr[0][i] * arr[1][i+1];
                right += arr[0][i+1] * arr[1][i];
            }
        }

        double abs = Math.abs(left - right);
        answer = abs/2.0;




        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.1f", answer));
        System.out.println(sb);
    }




}
