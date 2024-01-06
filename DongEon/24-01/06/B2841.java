package baekjoon.year24.month1.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2841 {

  static int n;
  static int p;

  static Stack<Integer>[] push;

  static int answer;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());

    // 기타 줄은 1번부터 6번까지 있다.
    push = new Stack[7];
    for(int i = 0; i < 7; i++) {
      push[i] = new Stack<Integer>();
    }

    for(int i = 0; i < n; i++) {
      int line = 0;
      int plat = 0;

      st = new StringTokenizer(br.readLine());
      line = Integer.parseInt(st.nextToken());
      plat = Integer.parseInt(st.nextToken());

      while(!push[line].isEmpty() && push[line].peek() > plat) {
        push[line].pop();
        answer +=1;
      }

      if(!push[line].isEmpty() && push[line].peek() != plat) {
        push[line].push(plat);
        answer += 1;
      }

      if(push[line].isEmpty()) {
        push[line].push(plat);
        answer += 1;
      }



    }

    System.out.println(answer);


  }


}
