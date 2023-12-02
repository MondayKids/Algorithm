package baekjoon.backjoon12.day0110.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;


/*


remove 메소드를 사용하면 O(n) 이라 시간 초과 발생
treemap활용
 */
public class B7662 {

  static int t;
  static int n;
  static TreeMap<Integer, Integer> numbers;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      numbers = new TreeMap<>();

      while (n-- > 0) {
        String[] split = br.readLine().split(" ");
        String order = split[0];
        int number = Integer.parseInt(split[1]);

        // 삽입
        if (order.equals("I")) {
          numbers.put(number, numbers.getOrDefault(number, 0) + 1);
        }
        // 삭제
        else if (order.equals("D")) {

          if(numbers.isEmpty()) {
            continue;
          }



          int removeNumber = 0;
          if(number == 1) removeNumber = numbers.lastKey();
          else if(number == -1) removeNumber = numbers.firstKey();
          int count = numbers.get(removeNumber) - 1;
          if(count == 0) {
            numbers.remove(removeNumber);
          }
          else {
            numbers.put(removeNumber, count);
          }
        }
      }

      if(numbers.isEmpty()) {
        sb.append("EMPTY").append("\n");
      }
      else {
        sb.append(numbers.lastKey()).append(" ").append(numbers.firstKey()).append("\n");
      }
    }

    System.out.println(sb);

  }

}
