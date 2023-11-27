import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/13549
public class Main_B_13549_숨바꼭질3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 1));

        while (!q.isEmpty()) {
            Node node = q.poll();

            int back = node.point - 1;
            int front = node.point + 1;
            int teleport = node.point * 2;

            if (isInRange(teleport) && visited[teleport] > node.cost) {
                visited[teleport] = node.cost;
                q.add(new Node(teleport, node.cost));
            }

            if (isInRange(back) && visited[back] > node.cost + 1) {
                visited[back] = node.cost+1;
                q.add(new Node(back, node.cost+1));
            }

            if (isInRange(front) && visited[front] > node.cost + 1) {
                visited[front] = node.cost+1;
                q.add(new Node(front, node.cost+1));
            }
        }
        System.out.println(visited[K] - 1);
    }

    // 범위 체크
    private static boolean isInRange(int point) {
        return point >= 0 && point <= 100000;
    }

    static class Node {
        int point;
        int cost;

        public Node(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }
    }
}
