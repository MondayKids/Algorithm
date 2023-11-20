package baekjoon.backjoon11.day1120.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
이진 검색 트리
https://www.acmicpc.net/problem/5639
 */

public class B5639 {

  static Node root;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    root = new Node(Integer.parseInt(br.readLine()));

    while(true) {
      String input = br.readLine();
      if(input == null || input.equals("")) {
        break;
      }
      int number = Integer.parseInt(input);
      root.insert(number);
    }

    postOrder(root);

  }

  public static void postOrder(Node node) {
    if (node == null) {
      return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.number);
  }



  public static class Node {
    int number;
    Node left;
    Node right;

    Node(int number) {
      this.number = number;
    }

    Node(int number, Node left, Node right) {
      this.number = number;
      this.left = left;
      this.right = right;
    }

    void insert(int n) {
      if(n < this.number) {
        if(this.left == null) {
          this.left = new Node(n);
        }
        else {
          this.left.insert(n);
        }
      }
      else {
        if(this.right == null) {
          this.right = new Node(n);
        }
        else {
          this.right.insert(n);
        }
      }

    }


  }
}
