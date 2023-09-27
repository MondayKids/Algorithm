import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/14501
public class Main_B_14501_퇴사 {

    static class Node {
        int day;
        int cost;

        public Node(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Node[] list = new Node[N];

        for (int i=0; i<N; i++) {
            Node input = new Node(sc.nextInt(), sc.nextInt());
            list[i] = input;
        }

        int[] dp = new int[N+1];
        // 모든 경우 조합 해보기
        for (int i=0; i<N; i++) {
            Node cur = list[i];
            if (i + cur.day <= N) {
                // 날짜가 범위를 넘어가지 않는 경우
                dp[i + cur.day] = Math.max(dp[i + cur.day], dp[i] + cur.cost);
            }

            // 해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당 넣어주기
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
