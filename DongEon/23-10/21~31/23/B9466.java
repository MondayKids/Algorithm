package baekjoon.backjoon10.day2131.day23;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
텀 프로젝트
https://www.acmicpc.net/problem/9466
 */
public class B9466 {

    static int t;
    static int n;
    static int[] board;
    static StringBuilder sb;

    static boolean[] visited; // 방문 여부 확인
    static boolean[] finished; // 탐색 완료
    static int result;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++) {
                board[j] = Integer.parseInt(st.nextToken());
            }
            simulation();
        }

        System.out.println(sb.toString());

    }


    public static void simulation() {

        visited = new boolean[n+1];
        finished = new boolean[n+1];
        result = 0;

        for(int i = 1; i < n+1; i++) {
            if(finished[i] == false) {
                search(i);
            }
        }



        sb.append(n-result).append("\n");

    }

    // 순환을 찾는 메소드
    // finished를 통해 중복 탐색 예방
    // 순환을 찾으면 다시 순환을 돌면서 result+1, finished 를 true 처리
    // finished가 true 이므로 순환을 마치고 나옴
    public static void search(int number) {

        if(finished[number] == true) {
            return;
        }

        if(visited[number]) {
            finished[number] = true;
            result++;
        }

        visited[number] = true;
        search(board[number]);


        finished[number] = true;
        visited[number] = false;

    }
}
