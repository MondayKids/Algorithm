import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2667
public class Main_B_2667_단지번호붙이기 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 지도의 크기

        int[][] arr = new int[N][N];

        for (int i=0; i<arr.length; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j=0; j<arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(temp[j] + "");
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0; i< arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {

                if (arr[i][j] == 1) {
                    int cnt = 1;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    arr[i][j] = 2; // 방문 처리

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int d=0; d<4; d++) {
                            int nr = dr[d] + cur[0];
                            int nc = dc[d] + cur[1];

                            if (nr<0 || nr>=N || nc<0 || nc>=N) continue; // 범위 체크

                            if (arr[nr][nc] == 1) {
                                q.add(new int[] {nr, nc});
                                arr[nr][nc] = 2; // 방문처리
                                cnt++;
                            }
                        }
                    }

                    list.add(cnt);
                }

            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int x : list) {
            System.out.println(x);
        }

    }

    private static void print(int[][] arr) {
        for (int i=0; i< arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
