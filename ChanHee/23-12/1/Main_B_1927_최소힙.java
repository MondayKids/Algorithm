import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1927
public class Main_B_1927_최소힙 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            long input = sc.nextLong();

            if (input == 0) { // 최소 값 출력
                if (pq.isEmpty()) sb.append(0).append("\n");
                else {
                    sb.append(pq.poll()).append("\n");
                }
            } else { // 삽입
                pq.add(input);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
