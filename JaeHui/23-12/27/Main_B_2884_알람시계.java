import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        if (min - 45 < 0) {
            min += 15;
            hour--;
            if (hour < 0) hour = 23;
        } else min -= 45;
        System.out.println(hour + " " + min);
        br.close();
    }
}
