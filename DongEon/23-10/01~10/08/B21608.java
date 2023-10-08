package baekjoon.backjoon10.day0110.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
상어 초등학교
https://www.acmicpc.net/problem/21608


1. 비어있는 칸 중 좋아하는 학생이 많이 인접한 칸에 자리를 정한다.
2. 1의 조건이 여러개면 비어있는 칸이 가장 많은 칸으로 간다.
3. 2를 만족하는 칸이 많으면 행의 번호, 열의 번호 작은 칸으로 간다.


3
5 6 1 8 4
6 7 4 8 2
7 3 1 6 9
4 1 6 9 7
8 5 4 6 3
2 6 4 3 7
1 2 5 8 4
9 4 7 5 6
3 4 1 6 5
44
 */
public class B21608 {

    static int n;
    static int[] order; // 학생 배치 순서
    static int[][] friendArr; // 학생 별 좋아하는 친구들 저장
    static int[][] board; // 배치
    static int[][] room; // 교실
    static boolean[] visited; // 학생이 배치되어 있는지 여부 확인

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static int answer = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());



        order = new int[n*n];
        friendArr = new int[n*n+1][4];
        StringTokenizer st = null;
        for(int i = 1; i <= n*n; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i-1] = student;
            for(int j = 0; j < 4; j++) {
                int friend = Integer.parseInt(st.nextToken());
                friendArr[student][j] = friend;
            }
        }

        board = new int[n*n+1][2];
        room = new int[n][n];
        visited = new boolean[n*n+1];

        // 자리 배치
        for(int i = 0; i < n*n; i++) {
            place(order[i]);
        }


        // 만족도 조사
        answer = 0;
        satisfiction();

        System.out.println(answer);



    }

    public static void satisfiction() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer += scoreCheck(i,j,room[i][j]);
            }
        }
    }

    public static int scoreCheck(int y, int x, int number) {

        int result = 0;

        int count = 0;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(scoreBoardCheck(ny, nx)) {
                for(int j = 0; j < 4; j++) {
                    if(friendArr[number][j] == room[ny][nx]) {
                        count++;
                    }
                }
            }
        }

        if(count == 0) {
            result = 0;
        }
        else if(count == 1) {
            result = 1;
        }
        else if(count == 2) {
            result = 10;
        }
        else if(count == 3) {
            result = 100;
        }
        else if(count == 4) {
            result = 1000;
        }

        return result;

    }

    public static boolean scoreBoardCheck(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < n) {
            return true;
        }
        else {
            return false;
        }
    }




    /*
    학생이 들어왔을 때 어디에 배치할지 board

    1. 좋아하는 학생이 배치되어 있는 경우 4방향 탐색
    인접한 학생 수 Count 큰 거 가져옴
    y,x가 낮은거에 선택

    2. 학생이 없는 경우 인접한 곳에 비어있는 칸이 많은 곳에 배치

    */

    public static void place(int number) {

        // System.out.println(number);

        // 좋아하는 학생이 배치 되어 있는지 확인
        Queue<Integer> likeQue = new LinkedList<>();
        for(int i = 0; i < 4; i++) {
            int friend = friendArr[number][i];
            if(visited[friend]) {
                likeQue.add(friend);
            }
        }

        // 좋아하는 친구가 있을 경우
        if(likeQue.size() >= 1) {
            // 좋아하는 친구가 있지만 배치를 할 수 없는 경우
            if(placeHaveFriend(number, likeQue)) {
                // System.out.println("work");
                placeNoFriend(number);
            }
        }
        // 좋아하는 친구가 없을 경우. 가장 빈 칸 많은 곳 행과 열이 작으면서
        else {
            placeNoFriend(number);
        }

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.print(room[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();





    }

    // 좋아하는 친구가 없는 경우, 빈 칸이 가장 많은 곳
    public static void placeNoFriend(int number) {

        int selecty = -1;
        int selectx = -1;

        int result = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(room[i][j] != 0) {
                    continue;
                }

                int blank = countBlank(i,j);
                if(result < blank) {
                    result = blank;
                    selecty = i;
                    selectx = j;
                }
                else if(result == blank) {
                    if(i < selecty) {
                        selecty = i;
                        selectx = j;
                    }
                    else if(i == selecty && j < selectx) {
                        selecty = i;
                        selectx = j;
                    }
                }
            }
        }

        room[selecty][selectx] = number;
        board[number][0] = selecty;
        board[number][1] = selectx;
        visited[number] = true;

    }

    // 근처에 빈 칸 갯수 세기
    public static int countBlank(int y, int x) {

        int result = 0;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(check(ny, nx)) {
                result++;
            }
        }

        return result;

    }

    // 좋아하는 친구가 이미 배치되어 있는 경우
    public static boolean placeHaveFriend(int number, Queue<Integer> likeQue) {

        // 인접한 곳에 좋아하는 학생이 가장 많은 칸 찾기
        int[][] simulation = new int[n][n];

        int result = 0;
        int blank = 0;
        int selecty = -1;
        int selectx = -1;

        while(!likeQue.isEmpty()) {
            Integer friend = likeQue.poll();
            int friendy = board[friend][0];
            int firendx = board[friend][1];

            for(int i = 0; i < 4; i++) {
                int ny = friendy + dy[i];
                int nx = firendx + dx[i];

                if(check(ny,nx)) {

                    simulation[ny][nx] += 1;
                    if(simulation[ny][nx] > result) {
                        result = simulation[ny][nx];
                        blank = countBlank(ny,nx);
                        selecty = ny;
                        selectx = nx;
                    }
                    else if(simulation[ny][nx] == result) {

                        int newBlank = countBlank(ny,nx);
                        if(newBlank > blank) {
                            blank = newBlank;
                            selecty = ny;
                            selectx = nx;
                        }
                        else if(newBlank == blank) {
                            if(ny < selecty) {
                                selecty = ny;
                                selectx = nx;
                            }
                            if(ny == selecty && nx < selectx) {
                                selecty = ny;
                                selectx = nx;
                            }
                        }
                    }
                }
            }
        }

        if(selecty == -1 && selectx == -1) {
            return true;
        }
        else {
            room[selecty][selectx] = number;
            board[number][0] = selecty;
            board[number][1] = selectx;
            visited[number] = true;
            return false;
        }
    }


    public static boolean check(int y, int x) {
        if(y >= 0 && y < n && x >= 0 && x < n && room[y][x] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
