package baekjoon.backjoon9.day24;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
괄호 추가하기
https://www.acmicpc.net/problem/16637
 */

public class B16637 {

    static int n, m;
    static List<Integer> number;
    static List<Character> operation;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = n/2;

        number = new ArrayList<>();
        operation = new ArrayList<>();

        String str = br.readLine();


        for(int i = 1; i < n+1; i++) {
            if(i % 2 == 1) {
                number.add(str.charAt(i-1) - '0');
            }
            else {
                operation.add(str.charAt(i-1));
            }
        }

        answer = Integer.MIN_VALUE; // 음수가 나올수도 있다
        dfs(0, number.get(0));
        System.out.println(answer);

    }

    // 연산 순서 정하기
    public static void dfs(int stage, int left) {

        if(stage >= m) {
            answer = Math.max(answer, left);
            return;
        }


        // 그냥 계산한 경우
        int num = calc(left, operation.get(stage), number.get(stage + 1));
        dfs(stage+1, num);

        // 괄호를 친 경우
        if(stage+1 < m) {
            int num1 = calc(number.get(stage+1), operation.get(stage+1), number.get(stage +2));
            int num2 = calc(left, operation.get(stage), num1);
            dfs(stage+2, num2);
        }
    }


    // 사칙 연산
    public static int calc(int num1, char op, int num2) {
        int result = 0;
        if(op == '+') {
            result = num1 + num2;
        }
        else if(op == '-') {
            result = num1 - num2;
        }
        else if(op == '*') {
            result = num1 * num2;
        }

        return result;
    }

}
