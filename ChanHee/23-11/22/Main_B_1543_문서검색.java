import java.util.Scanner;

// https://www.acmicpc.net/problem/1543
public class Main_B_1543_문서검색 {

    public static void main(String[] args) {
        // 앞에서 부터 일치할 때 마다 개수 증가, 인데스 변경

        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();
        String target = sc.nextLine();

        int left = 0;
        int answer = 0;

        while (true) {
            // 종료 조건
            if (left + target.length() - 1 > data.length() - 1) break;

            String sub = data.substring(left, left + target.length());
            if (sub.equals(target)) {
                answer++;
                left += target.length();
            } else {
                left++;
            }
        }

        System.out.println(answer);
    }
}
