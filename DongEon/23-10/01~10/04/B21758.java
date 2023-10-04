package baekjoon.backjoon10.day0110.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
꿀 따기
https://www.acmicpc.net/problem/21758

누적합
3가지 경우로 나누어서 계산
꿀통 벌1 벌2
벌1 꿀통 벌2
벌1 벌2 꿀통
가운데가 위치를 이동

 */
public class B21758 {

    static int n;
    static long[] board;
    static long[] leftPrefix; // 왼쪽부터 시작
    static long[] rightPrefix; // 오른쪽부터 시작

    static int beeHouse;
    static int beeOne;
    static int beeTwo;

    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        board = new long[n];
        for(int i = 0; i < n; i++) {
            board[i] = Long.parseLong(st.nextToken());
        }

        leftPrefix = new long[n];
        long prefer = 0;
        for(int i = 0; i < n; i++) {
            leftPrefix[i] = board[i] + prefer;
            prefer = leftPrefix[i];
        }

        rightPrefix = new long[n];
        prefer = 0;
        for(int i = n-1; i >= 0; i--) {
            rightPrefix[i] = board[i] + prefer;
            prefer = rightPrefix[i];
        }

        answer = 0;

        // 벌통, 벌2, 벌1
        left();

        // 벌1, 벌통, 벌2
        center();

        // 벌1, 벌2, 벌통
        right();

        System.out.println(answer);

    }

    // 벌통 왼쪽, 벌1 맨 오른쪽, 벌2 움직임
    public static void left() {
        beeHouse = 0;
        beeOne = n-1;

        for(int i = 1; i < n-1; i++) {
            beeTwo = i;
            long result = rightPrefix[beeHouse] - rightPrefix[beeOne];
            result += rightPrefix[beeHouse] - rightPrefix[beeTwo];
            result -= board[beeTwo];
            answer = Math.max(answer, result);
        }

    }

    // 벌1 왼쪽, 벌통, 벌2 오른쪽
    public static void center() {
        beeOne = 0;
        beeTwo = n-1;

        for(int i = 1; i < n-1; i++) {
            beeHouse = i;
            long result = 0;
            result += leftPrefix[beeHouse] - leftPrefix[beeOne];
            result += rightPrefix[beeHouse] - rightPrefix[beeTwo];
            answer = Math.max(answer, result);
        }

    }

    // 벌1, 벌2, 벌통
    public static void right() {
        beeOne = 0;
        beeHouse = n-1;

        for(int i = 1; i < n-1; i++) {
            beeTwo = i;
            long result = leftPrefix[beeHouse] - leftPrefix[beeOne];
            result += leftPrefix[beeHouse] - leftPrefix[beeTwo];
            result -= board[beeTwo];
            answer = Math.max(answer, result);
        }
    }






}
