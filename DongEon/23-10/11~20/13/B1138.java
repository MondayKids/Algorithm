package baekjoon.backjoon10.day1120.day13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
한 줄로 서기
https://www.acmicpc.net/problem/1138

키 1 ~ N
왼쪽에 키 큰 사람이 몇 명 있는지

키 큰 사람부터 카운팅
 */

public class B1138 {

    static int n;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();

        for(int i = n; i > 0; i--) {
            int index = number[i-1];
            list.add(index, i);
        }

        for(Integer data : list) {
            System.out.print(data + " ");
        }



    }

}
