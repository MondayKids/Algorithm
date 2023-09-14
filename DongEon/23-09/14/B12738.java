package baekjoon.backjoon9.day14;


/*
가장 긴 증가하는 부분 수열 3
https://www.acmicpc.net/problem/12738
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B12738 {

    static int n;
    static int[] board;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int number = board[i];

            if(list.get(list.size()-1) < number) {
                list.add(number);
            }
            else {
                int index = find(number);
                list.set(index, number);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size() - 1);
        System.out.println(sb);


    }

    public static int find(int number) {
        int s = 0;
        int e = list.size()-1;

        while(s < e) {
            int mid = (s+e)/2;


            if (list.get(mid) < number) {
                s = mid + 1;
            }
            else {
                e = mid;
            }
        }

        return e;
    }
}












