/*
조건 1 : 각각의 가로줄과 세로줄에는 1~9 숫자가 한 번씩만 나타나야 한다.
조건 2 : 굵은 선으로 구분되어 있는 3*3 정사각형 안에도 1~9 숫자가 한 번씩만 나타나야 한다.

빈칸을 하나씩 채워가면서 유효한지 검사한다.
만약 조건에 맞지않으면 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2580
public class Main_B_2580_스도쿠 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map = new int[9][9];
    static ArrayList<int[]> zero_list = new ArrayList<>(); // 빈칸 리스트
    public static void main(String[] args) throws IOException {
        input(); // 스도쿠 초기 입력
        fill(0, 0);
    }

    private static void input() throws IOException{
        StringTokenizer st;
        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) zero_list.add(new int[] {i, j});
            }
        }
    }

    // 스도쿠 채우기
    private static void fill(int row, int col) {
        // 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
        if (col == 9) {
            fill(row+1, 0);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (row == 9) {
            print(map);
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int i=1; i<=9; i++) {
                if (possibility(row, col, i)) {
                    map[row][col] = i;
                    fill(row, col+1);
                }
            }
            // 백트래킹 후 원상복귀
            // 위 반복문으로 값이 맞지 않을 경우 -> 초기화 필요
            map[row][col] = 0;
            return;
        }

        fill(row, col+1);
    }

    public static boolean possibility(int row, int col, int value) {

        // 같은 행 검사
        for (int i=0; i<9; i++) {
            if (map[row][i] == value) return false;
        }

        // 같은 열 검사
        for (int i=0; i<9; i++) {
            if (map[i][col] == value) return false;
        }

        // 3*3 검사
        int start_row = (row / 3) * 3;
        int start_col = (col / 3) * 3;

        for (int i=start_row; i<start_row+3; i++) {
            for (int j=start_col; j<start_col+3; j++) {
                if (map[i][j] == value) return false;
            }
        }

        return true;
    }

    private static void print(int[][] map) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
