/*
0 : N극
1 : S극

1 0 [1] 0 1 1 [1] 1
0 1 [1] 1 1 1 [0] 1

톱니바퀴 번호, 시계 or 반시계
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14891
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 4개의 톱니바퀴
    static char[] t1;
    static char[] t2;
    static char[] t3;
    static char[] t4;

    static boolean[] visited; // 방문 배열
    static String[] mode_arr; // 회전 모드 저장 배열

    // 인덱스로 접근하기 위한 리스트
    static ArrayList<char[]> list;

    public static void main(String[] args) throws IOException {
        t1 = br.readLine().toCharArray();
        t2 = br.readLine().toCharArray();
        t3 = br.readLine().toCharArray();
        t4 = br.readLine().toCharArray();

        list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        int K = Integer.parseInt(br.readLine()); // 회전 횟수
        for (int i=0; i<K; i++) {
            String[] input = br.readLine().split(" ");
            int     number = Integer.parseInt(input[0]) - 1; // 톱니바퀴 인덱스
            String  mode  = (Integer.parseInt(input[1]) == 1 ? "RIGHT" : "LEFT"); // 1 : RIGHT, -1 : LEFT

            visited = new boolean[4];
            mode_arr = new String[4];
            Arrays.fill(mode_arr, "STOP");

            mode_arr[number] = mode;
            toLeft(number); // 현재 톱니바퀴에서 왼쪽으로 회전여부 기록
            toRight(number); // 현재 톱니바퀴에서 오른쪽으로 회전여부 기록

            // 회전 여부 배열에 따라 회전 수행
            for (int d=0; d<4; d++) {
                String m = mode_arr[d];
                if (m.equals("STOP")) continue;
                turn(m, list.get(d)); // 회전
            }
        }

        int sum = 0; // 정답
        for (int d=0; d<4; d++) {
            char[] cur = list.get(d);

            // 12시 방향 자석이 S극이라면
            if (cur[0] == '1') {
                sum += Math.pow(2, d);
            }
        }
//        print4();
        System.out.println(sum); // 정답 출력
    }

    private static void toLeft(int number) {
        char[] cur = list.get(number);

        if (number -1 < 0) return;
        if (cur[6] != list.get(number-1)[2]) {
            if (mode_arr[number].equals("LEFT")) {
                mode_arr[number-1] = "RIGHT";
                toLeft(number-1);
            } else if (mode_arr[number].equals("RIGHT")) {
                mode_arr[number-1] = "LEFT";
                toLeft(number-1);
            }
        }
    }

    private static void toRight(int number) {
        char[] cur = list.get(number);

        if (number+1 >=4) return;
        if (cur[2] != list.get(number+1)[6]) {
            if (mode_arr[number].equals("LEFT")) {
                mode_arr[number+1] = "RIGHT";
                toRight(number+1);
            } else if (mode_arr[number].equals("RIGHT")) {
                mode_arr[number+1] = "LEFT";
                toRight(number+1);
            }
        }
    }

    private static void turn(String mode, char[] arr) {
        switch(mode) {
            case "LEFT": // 반시계
                char temp = arr[0]; // 0번째 원소 저장
                for (int i=0; i<7; i++) {
                    arr[i] = arr[i+1];
                }
                arr[7] = temp;

                break;
            case "RIGHT": // 시계
                temp = arr[7]; // 7번째 원소 저장
                for (int i=7; i>0; i--) {
                    arr[i] = arr[i-1];
                }
                arr[0] = temp;

                break;
        }
    }

    // 디버깅용
    private static void print(char[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 디버깅용
    private static void print4() {
        for (int i=0; i<t1.length; i++) {
            System.out.print(t1[i] + " ");
        }
        System.out.println();
        for (int i=0; i<t2.length; i++) {
            System.out.print(t2[i] + " ");
        }
        System.out.println();
        for (int i=0; i<t3.length; i++) {
            System.out.print(t3[i] + " ");
        }
        System.out.println();
        for (int i=0; i<t4.length; i++) {
            System.out.print(t4[i] + " ");
        }
        System.out.println();
    }
}
