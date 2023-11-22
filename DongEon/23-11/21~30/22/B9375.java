package baekjoon.backjoon11.day2130.day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B9375 {

  static int t;
  static int n;
  static Map<String, Integer> wear;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < t; i++) {
      wear = new HashMap<>();
      n = Integer.parseInt(br.readLine());
      for(int j = 0; j < n; j++) {
        String[] split = br.readLine().split(" ");
        wear.put(split[1], wear.getOrDefault(split[1], 0) + 1);
      }
      int answer = 1;
      List<Integer> list = new ArrayList<>();
      for (String key : wear.keySet()) {
        answer *= wear.get(key) + 1;
      }

      sb.append(answer-1).append("\n");


    }
    System.out.println(sb.toString());


  }

}
