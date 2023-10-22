/*
      1
    6    4
  3      7   2
5
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11725
public class Main_B_11725_트리의부모찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 개수 입력

        // 트리 구조 표현을 위한 그래프 구현
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i=0; i<N; i++) {
            tree.add(new ArrayList<>());
        }

        // 그래프 입력
        for (int i=0; i<N-1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        boolean[] visited = new boolean[N]; // 방문 여부 확인용 배열
        int[] parentNode = new int[N]; // 부모 노드 저장 배열

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int node : tree.get(cur))
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                    parentNode[node] = cur; // 부모 노드 찾은 후 저장
                }
        }

        // 1번(루트) 노드를 제외한 나머지 노드의 부모 노드 출력
        for (int i=1; i<N; i++) {
            System.out.println(parentNode[i] + 1);
        }
    }

}
