package baekjoon.backjoon9.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B23300 {

    static int n,q;

    static int now;
    static List<Integer> backList;
    static List<Integer> frontList;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 웹 페이지 종류 수
        q = Integer.parseInt(st.nextToken()); // 사용자가 수행하는 작업 개수

        backList = new ArrayList<>();
        frontList = new ArrayList<>();

        for(int i = 0; i < q; i++) {
            String data = br.readLine();
            String[] spt = data.split(" ");

            if (spt[0].equals("B")) {
                back();
            } else if (spt[0].equals("F")) {
                front();
            } else if (spt[0].equals("A")) {
                access(Integer.parseInt(spt[1]));
            } else if (spt[0].equals("C")) {
                compact();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(now).append("\n");

        if(backList.size() == 0) {
            sb.append(-1).append("\n");
        }
        else {
            for(int i = backList.size()-1; i >= 0 ; i--) {
                sb.append(backList.get(i)).append(" ");
            }
            sb.append("\n");
        }

        if(frontList.size() == 0) {
            sb.append(-1).append("\n");
        }
        else {
            for(int i = frontList.size()-1; i >= 0 ; i--) {
                sb.append(frontList.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    // 뒤로 가기
    public static void back() {

        // 0개 일 때 작업 무시
        if(backList.size() == 0) {
            return;
        }

        frontList.add(now);
        now = backList.remove(backList.size() - 1);

    }

    // 앞으로 가기
    public static void front() {

        // 0개 일 때 작업 무시
        if(frontList.size() == 0) {
            return;
        }

        backList.add(now);
        now = frontList.remove(frontList.size() - 1);

    }

    // 웹 페이지 접속
    public static void access(int number) {

        // 앞으로 가기 공간 모두 삭제
        frontList = new ArrayList<>();

        // 처음으로 웹페이지에 접속하는게 아닐 경우
        if(now != 0) {
            backList.add(now);
        }

        now = number;
    }

    // 압축 실행
    public static void compact() {
        List<Integer> spare = new ArrayList<>();

        if(backList.size() == 0) {
            return;
        }

        int number = backList.get(0);
        spare.add(backList.get(0));

        for (int i = 0; i < backList.size(); i++) {

            if(number != backList.get(i)) {
                number = backList.get(i);
                spare.add(backList.get(i));
            }

        }

        backList = new ArrayList<>(spare);
    }




}
