import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1966
public class Main_B_1966_프린터큐 {

    static class Node {
        int important;
        int index;

        public Node(int important, int index) {
            this.important = important;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int TC = sc.nextInt();

        for (int tc=1; tc<=TC; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<Node> q = new LinkedList<>();

            for (int i=0; i<n; i++) {
                Node node = new Node(sc.nextInt(), i);
                q.add(node);
            }

            int count = 0;
            while (!q.isEmpty())
            {
                Node cur = q.poll(); // 현재 노드

                if (isRemainImportant(q, cur)) {
                    q.add(cur);
                } else {
                    count++;
                    if (cur.index == m) break;
                }

//                System.out.print("현재 큐의 상태 : ");
//                for (Node node : q) {
//                    System.out.print("[" + node.important + ", " + node.index +"]" + " ");
//                }
//                System.out.println();

            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isRemainImportant(Queue<Node> q, Node cur) {
        for (Node data : q) {
            if (data.important > cur.important) {
                return true;
            }
        }

        return false;
    }
}
