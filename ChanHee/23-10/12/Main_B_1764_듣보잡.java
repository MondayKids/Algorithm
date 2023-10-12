import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1764
public class Main_B_1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 듣
        int M = Integer.parseInt(st.nextToken()); // 보

        Set<String> D = new HashSet<>(); // 듣
        List<String> nameList = new ArrayList<>(); // 듣보

        for (int i=0; i<N; i++) {
            D.add(br.readLine()); // 듣
        }

        for (int i=0; i<M; i++) {
            String name = br.readLine(); // 보
            if (D.contains(name)) {
                nameList.add(name); // 듣보
            }
        }

        Collections.sort(nameList); // 이름 순서로 정렬

        sb.append(nameList.size()).append("\n");
        for (String name : nameList) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
