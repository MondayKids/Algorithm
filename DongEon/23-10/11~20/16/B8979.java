package baekjoon.backjoon10.day1120.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
올림픽
https://www.acmicpc.net/problem/8979
 */

public class B8979 {

    static int n;
    static int k;
    static List<country> countryList;
    static int[] rating;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        countryList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countryList.add(new country(number, gold, silver, bronze));
        }

        Collections.sort(countryList);

        rating = new int[n+1];
        int rate = 1;
        int dup = 1;

        country before = countryList.get(0);
        rating[before.number] = 1;
        for (int i = 1; i < countryList.size(); i++) {

            country c = countryList.get(i);

            if(before.gold == c.gold && before.silver == c.silver && before.bronze == c.bronze) {
                rating[c.number] = rate;
                dup += 1;
            }
            else {
                rate += dup;
                rating[c.number] = rate;
                dup = 1;
            }

            before = c;
        }


        System.out.println(rating[k]);






    }

    public static class country implements Comparable<country> {
        int number;
        int gold;
        int silver;
        int bronze;

        country(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(country c) {
            if(this.gold == c.gold) {
                if(this.silver == c.silver) {
                    return c.bronze - this.bronze;
                }
                else {
                    return c.silver - this.silver;
                }
            }
            else {
                return c.gold - this.gold;
            }
        }
    }


}
