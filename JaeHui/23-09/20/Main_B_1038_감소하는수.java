package BOJ;

import java.io.*;
import java.util.*;
public class Main_B_1038_감소하는수 {

    static List<Long> list;

    static void decreaseNum(long n) {
        list.add(n);
        if (n > 9_876_543_210L) return;
        for (int i = 0; i < n % 10; i++)
            decreaseNum(n * 10 + i);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < 10; i++) decreaseNum(i);
        Collections.sort(list);

        if (N >= list.size()) System.out.println(-1);
        else System.out.println(list.get(N));
        br.close();
    }
}
