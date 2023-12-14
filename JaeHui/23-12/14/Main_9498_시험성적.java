import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        if (N >= 90) sb.append("A");
        else if (N >= 80) sb.append("B");
        else if (N >= 70) sb.append("C");
        else if (N >= 60) sb.append("D");
        else sb.append("F");
        System.out.println(sb.toString());
        br.close();
    }
