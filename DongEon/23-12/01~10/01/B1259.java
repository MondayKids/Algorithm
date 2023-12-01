package baekjoon.backjoon12.day0110.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1259 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String input = "";
    do {
      input = br.readLine();
      if(input.equals("0")) {
        break;
      }

      String pelindrom = "";
      for(int i = input.length()-1; i >= 0; i--) {
        pelindrom = pelindrom + input.charAt(i);
      }

      if(input.equals(pelindrom)) {
        sb.append("yes\n");
      }
      else {
        sb.append("no\n");
      }

    } while(!input.equals("0"));

    System.out.println(sb);




  }

}
