package baekjoon.backjoon10.day2131.day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B25757 {

    static int n;
    static char type;
    static int game;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        type = st.nextToken().charAt(0);

        if(type == 'Y') {
            game = 1;
        }
        else if(type == 'F') {
            game = 2;
        }
        else if(type == 'O') {
            game = 3;
        }

        Set<String> name = new HashSet<>();
        for(int i = 0; i < n; i++) {
            name.add(br.readLine());
        }

        int answer = name.size() / game;
        System.out.println(answer);




    }

}
