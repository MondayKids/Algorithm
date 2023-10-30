/*
그래프 탐색으로 인접한 도시의 인구를 구한다.

둘의 차이를 비교한다.

분리된 도시의 집합은 무조건 1개 이상이어야 한다. (인접한 구역이 없다면 -1 출력)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/17471
public class Main_B_17471_게리맨더링 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] nums;
    static ArrayList<Integer>[] list;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 구역의 개수
        nums = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            nums[i] = Integer.parseInt(st.nextToken()); // 인구 수
        }

        list = new ArrayList[N+  1];

        for (int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            // 인접 리스트 생성
            for (int j=1; j<=a; j++) {
                int b = Integer.parseInt(st.nextToken());
                list[i].add(b);
                list[b].add(i);
            }
        }


        selected = new boolean[N+1];
        // 게리 맨더링 수행
        for (int i=1; i<=N; i++) {
            gery(1, 1, i);
        }



        if (MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }

    }

    private static void gery(int start, int count, int stop) {

        if (count == stop) {
            ArrayList<Integer> team1 = new ArrayList<>();
            ArrayList<Integer> team2 = new ArrayList<>();

            for (int i=1; i<=N; i++) {
                if (selected[i]) {
                    team1.add(i);
                } else {
                    team2.add(i);
                }
            }

//            for (int x : team1) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//            for (int x : team2) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//            System.out.println();

            // 생성된 2개의 집단에서 구역의 가능성 체크
            if (team1.size()==0 || team2.size()==0) return;

            // 각 지역이 연결되어 있는지 체크
            if (check(team1) && check(team2)) {
                // 인구 수 차이 계산 후 MIN 업데이트
                MIN = Math.min(MIN, getDiff(team1, team2));
            }

            return;
        }
        // 조합 수행
        for (int i=start; i<=N; i++) {
            selected[i] = true;
            gery(i+1, count+1, stop);
            selected[i] = false;
        }
    }

    private static boolean check(ArrayList<Integer> team) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[team.get(0)] = true;
        q.add(team.get(0));

        int count = 1; // 방문한 지역의 개수
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i=0; i<list[cur].size(); i++) {
                int next = list[cur].get(i);
                if (cur == next) continue;
                if (team.contains(next) && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        if (count == team.size()) {
            return true;
        } else {
            return false;
        }
    }


    // 두 지역의 인구수 차이 반환
    private static int getDiff(ArrayList<Integer> team1, ArrayList<Integer> team2) {
        int r1 = 0;
        int r2 = 0;

        for (int x : team1) {
            r1 += nums[x];
        }

        for (int x : team2) {
            r2 += nums[x];
        }

        return Math.abs(r1 - r2);
    }
}
