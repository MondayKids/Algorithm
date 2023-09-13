package baekjoon.backjoon9.day13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
가장 긴 증가하는 부분 수열2
https://www.acmicpc.net/problem/12015
 */
public class B12015 {

    static int n;
    static int[] board;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        list.add(0);

        for(int i = 0; i < n; i++) {
            if(list.get(list.size()-1) < board[i]) {
                list.add(board[i]);
            }
            else {
                int index = find(board[i]);
                list.set(index, board[i]);
            }
        }



        StringBuilder sb = new StringBuilder();
        sb.append(list.size()-1);
        System.out.println(sb);

    }

    public static Integer find(int number) {

        int start = 0;
        int end = list.size()-1;

        int result = 0;

        while(start < end) {
            int mid = (start + end) / 2;

            if(list.get(mid) < number) {
                start = mid + 1;
                result = start;
            }
            else {
                end = mid;
            }
        }

        return result;

    }
}
