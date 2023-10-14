/*
이진 트리를 입력받아

전위, 중위, 후위 순회한 결과 출력하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1991
public class Main_B_1991_트리순회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수

        Tree tree = new Tree();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            tree.createNode(input[0], input[1], input[2]);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}

class Tree {
    Node root = new Node(".");

    void createNode(String mid, String left, String right) {
        if (root.data.equals(".")) {
            if (!mid.equals("."))
                root = new Node(mid);
            if (!left.equals("."))
                root.left = new Node(left);
            if (!right.equals("."))
                root.right = new Node(right);
        }

        else find(root, mid, left, right);
    }

    void find(Node node, String mid, String left, String right) {
        if (node == null) return;

        else if (mid.equals(node.data)) {
            if (!left.equals("."))
                node.left = new Node(left);
            if (!right.equals("."))
                node.right = new Node(right);
        }

        find(node.left, mid, left, right);
        find(node.right, mid, left, right);
    }

    void preOrder(Node node) {
        System.out.print(node.data);

        if (node.left != null)
            preOrder(node.left);
        if (node.right != null)
            preOrder(node.right);
    }

    void inOrder(Node node) {
        if (node.left != null)
            inOrder(node.left);

        System.out.print(node.data);

        if (node.right != null)
            inOrder(node.right);
    }

    void postOrder(Node node) {
        if (node.left != null)
            postOrder(node.left);


        if (node.right != null) {
            postOrder(node.right);
        }

        System.out.print(node.data);
    }
}

class Node {
    String data;
    Node left, right;

    Node(String data) {
        this.data = data;
    }
}
