package baekjoon.backjoon9.day04;

/*
트리 순회
https://www.acmicpc.net/problem/1991
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class B1991 {

    static int n;
    static Map<String, Node> nodeMap;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String start = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            nodeMap.put(start, new Node(left, right));
        }

        sb = new StringBuilder();
        preOrder("A");
        sb.append("\n");
        inOrder("A");
        sb.append("\n");
        postOrder("A");


        System.out.println(sb);

    }

    public static void preOrder(String start) {

        if (start.equals(".")) {
            return;
        }
        Node node = nodeMap.get(start);

        sb.append(start);

        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(String start) {
        if (start.equals(".")) {
            return;
        }

        Node node = nodeMap.get(start);

        inOrder(node.left);
        sb.append(start);
        inOrder(node.right);

    }

    public static void postOrder(String start) {
        if (start.equals(".")) {
            return;
        }

        Node node = nodeMap.get(start);


        postOrder(node.left);
        postOrder(node.right);
        sb.append(start);

    }


    public static class Node {
        String left;
        String right;

        Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }
}
