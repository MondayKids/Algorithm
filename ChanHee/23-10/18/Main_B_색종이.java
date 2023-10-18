import java.util.Scanner;

// https://www.acmicpc.net/problem/2563
public class Main_B_2563_색종이 {

    static int[][] paper = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i=0; i<N; i++) {
            int c = sc.nextInt();
            int r = sc.nextInt();

            update_paper(r, c);
        }

        System.out.println(count(paper));
    }

    static void update_paper(int r, int c) {
        for (int i=r; i<r+10; i++) {
            for (int j=c; j<c+10; j++) {
                paper[i][j] = 1;
            }
        }
    }

    static void print(int[][] paper) {
        for (int i=0; i<=100; i++) {
            for (int j=0; j<=100; j++) {
                System.out.print(paper[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count(int[][] paper) {
        int cnt = 0;
        for (int i=0; i<=100; i++) {
            for (int j=0; j<=100; j++) {
                if (paper[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
}
