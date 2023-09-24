/*
-를 만나면 이후에 오는 모든 양수를 더한다. (2번째 -를 만나기 전까지)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/1541
public class Main_B_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] arr = input.split("-");
        
        Queue<Integer> list = new LinkedList<>();
        for (String data : arr) {
            if (data.length() > 0) {
                int temp  = 0;
                String[] a = data.split("\\+");
                for (String x : a) {
                    temp +=Integer.parseInt(x);
                }
                list.add(temp);
            }
        }

        int sum = list.poll();
        if (arr[0].equals("")) {
            sum = -sum;
        }
        
        for (int x : list) {
            sum -= x;
        }

        System.out.println(sum);
    }
}
