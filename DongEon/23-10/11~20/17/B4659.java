package baekjoon.backjoon10.day1120.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4659 {

    static char[] moum = {'a','e','i','o','u'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        StringBuilder sb = new StringBuilder();

        while(true) {

            input = br.readLine();
            if(input.equals("end")) {
                break;
            }

            if(check(input)) {
                sb.append("<").append(input).append("> is acceptable. \n");
            }
            else {
                sb.append("<").append(input).append("> is not acceptable. \n");
            }

        }

        System.out.println(sb.toString());


    }

    public static boolean check(String input) {

        // 모음 하나 포함
        boolean flag1 = false;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(moumcheck(c)) {
                flag1 = true;
            }
        }
        if(flag1 == false) {
            return false;
        }

        // 모음 3개, 자음 3개 연속 오면 안됨
        if(input.length() >= 3) {

            for(int i = 0; i <= input.length() - 3; i++) {

                boolean f1 = moumcheck(input.charAt(i));
                boolean f2 = moumcheck(input.charAt(i+1));
                boolean f3 = moumcheck(input.charAt(i+2));
                if(f1 == f2 && f2 == f3) {
                    return false;
                }
            }
        }

        // 같은 글자 연속 2번 안됨 ee oo 제외
        if(input.length() >= 2) {
            for(int i = 0; i < input.length()-1; i++) {
                char c1 = input.charAt(i);
                char c2 = input.charAt(i+1);

                if(c1 == 'e' || c2 == 'o') {
                    continue;
                }
                else {
                    if(c1 == c2) {
                        return false;
                    }
                }
            }

        }

        return true;

    }

    public static boolean moumcheck(char c) {
        for(int i = 0; i < 5; i++) {
            if(moum[i] == c) {
                return true;
            }
        }
        return false;
    }

}
