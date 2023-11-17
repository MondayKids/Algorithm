import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

// https://www.acmicpc.net/problem/7662
public class Main_B_7662_이중우선순위큐 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static TreeMap<Long, Long> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++) {
            map.clear();
            int N = Integer.parseInt(br.readLine());
            for (int i=0; i<N; i++) {

                String[] input = br.readLine().split(" ");
                String command = input[0];
                long number = Long.parseLong(input[1]);

                switch (command) {
                    case "I":
                        insert(number);
                        break;
                    case "D":
                        delete(number);
                        break;
                }
            }
            // q의 최댓값, 최솟값 출력 (비어있으면 EMPTY)
            if (map.size() == 0) sb.append("EMPTY\n");
            else sb.append(map.lastKey() + " " + map.firstKey()).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    static void insert(long number) {
        map.put(number, map.getOrDefault(number, 0L) + 1);
    }

    static void delete(long flag) {
        if (map.size() == 0) return;

        long key = flag == 1 ? map.lastKey() : map.firstKey();
        long cnt = map.get(key);

        if (cnt == 1) {
            map.remove(key);
        } else {
            map.put(key, cnt - 1);
        }
    }
}
