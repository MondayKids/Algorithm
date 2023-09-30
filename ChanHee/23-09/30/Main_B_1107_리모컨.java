import java.util.Scanner;

// https://www.acmicpc.net/problem/1107
public class Main_B_1107_리모컨 {

    static int target;
    static int M;
    static boolean[] broken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        target = sc.nextInt();
        M = sc.nextInt();
        broken = new boolean[10]; // 고장난 버튼

        for (int i=0; i<M; i++) {
            int n = sc.nextInt();
            broken[n] = true;
        }

        int ans = Math.abs(target - 100);
        loopa : for (int i=0; i<=5000000; i++) {
            String str = String.valueOf(i);
            loopb : for (int j=0; j<=9; j++) {
                if (broken[j]) {
                    if (str.contains(String.valueOf(j))) {
                        continue loopa;
                    }
                }
            }

            // 만들 수 있는 리모컨 번호
            ans = Math.min(Math.abs(i - target) + str.length(), ans);
        }

        System.out.println(ans);
    }

}
