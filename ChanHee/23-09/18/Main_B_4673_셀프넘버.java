// https://www.acmicpc.net/problem/4673
public class Main_B_4673_셀프넘버 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[10001];

        for (int i=1; i<=10000; i++) {
            int rs = generate(i + "");

            if (rs > 10000) continue;
            visited[rs] = true;
        }

        for (int i=1; i<10000; i++) {
            if (!visited[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int generate(String x) {
        char[] arr = x.toCharArray();

        int result = Integer.parseInt(x);

        for (char t : arr) {
            String st = t + "";
            int it = Integer.parseInt(st);

            result += it;
        }

        return result;
    }
}
