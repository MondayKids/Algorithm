import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 덩치 = 키 + 몸무게
 *       x + y
 *
 * 키랑 몸무게 둘다 커야지 덩치가 큰 것
 *
 * 각 사람의 덩치 계산
 * (모든 사람 순회하며 덩치 계산)
 */

// https://www.acmicpc.net/problem/7568
public class Main_B_7568_덩치 {

    static class Human {
        private final int weight;
        private final int heigth;

        public Human(int weight, int heigth) {
            this.weight = weight;
            this.heigth = heigth;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        List<Human> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            list.add(new Human(w, h));
        }

        for (int i=0; i<N; i++) {
            Human h1 = list.get(i);
            int grade = 1;
            for (int j=0; j<N; j++) {
                if (i != j) {
                    Human h2 = list.get(j);

                    if (h1.heigth<h2.heigth && h1.weight<h2.weight) grade++;
                }
            }
            sb.append(grade).append(" ");
        }

        System.out.println(sb);
    }
}
