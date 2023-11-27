package baekjoon.backjoon11.day2130.day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1052 {

  static int n,k;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());


    int answer = 0;

    while (Integer.bitCount(n) > k) {
      /*
      -n 은 n 의 2의 보수, n과 -n을 & 연산하면 n의 가장 낮은 1비트만 남는다.
      n = 10100, -n = 01100, n & (-n) = 00100
       */
      answer += n & (-n);

      /*
      n += n & (-n) 은 n에 자신의 가장 낮은 1비트를 더한다는 뜻
      가장 낮은 1비트를 0으로 바꾼다.
      while문의 조건을 만족할 때 까지 1의 개수를 줄이는 것
       */
      n += n & (-n);
    }

    System.out.println(answer);



  }

}
