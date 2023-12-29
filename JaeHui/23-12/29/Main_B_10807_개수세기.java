import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (!map.containsKey(n)) map.put(n, 1);
            else map.put(n, map.get(n) + 1);
        }
        int v = Integer.parseInt(br.readLine());
        if (map.containsKey(v)) System.out.println(map.get(v));
        else System.out.println(0);
        br.close();
    }
}
