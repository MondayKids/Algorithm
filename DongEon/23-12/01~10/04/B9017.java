package baekjoon.backjoon12.day0110.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
크로스 컨트리
https://www.acmicpc.net/problem/9017
 */
public class B9017 {

  static int t;
  static int n;
  static int[] board;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = null;

    while(t-- > 0) {
      n = Integer.parseInt(br.readLine());
      board = new int[n];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < n; i++) {
        board[i] = Integer.parseInt(st.nextToken());
      }

      sb.append(rank()).append("\n");
    }

    System.out.println(sb);

  }

  public static int rank() {
    Map<Integer, Integer> teams = new HashMap<>();

    for(int i = 0; i < n; i++) {
      int number = board[i];
      teams.put(number, teams.getOrDefault(number, 0) + 1);
    }

    Set<Integer> excludeTeam = new HashSet<>();

    for(int team : teams.keySet()) {
      if(teams.get(team) < 6) {
        excludeTeam.add(team);
      }
    }

    Map<Integer, List<Integer>> teamRank = new HashMap<>();
    int rank = 1;
    for(int i = 0; i < n; i++) {
      if(!excludeTeam.contains(board[i])) {
        if(!teamRank.containsKey(board[i])) {
          List<Integer> temp =new ArrayList<>();
          temp.add(rank++);
          teamRank.put(board[i], temp);
        }
        else {
          teamRank.get(board[i]).add(rank++);
        }
      }
    }


    List<Integer> winner = new ArrayList<>();
    int result = Integer.MAX_VALUE;

    for (int number : teamRank.keySet()) {
      List<Integer> ranks = teamRank.get(number);
      int sumRank = 0;
      for(int i = 0; i < 4; i++) {
        sumRank += ranks.get(i);
      }
      if(result > sumRank) {
        result = sumRank;
        winner.clear();
        winner.add(number);
      }
      else if (result == sumRank) {
        winner.add(number);
      }
    }


    if(winner.size() == 1) {
      return winner.get(0);
    }
    else {
      int small = Integer.MAX_VALUE;
      int answer = 0;
      for(int number : winner) {
        int rankFive = teamRank.get(number).get(4);
        if(small > rankFive) {
          small = rankFive;
          answer = number;
        }
      }
      return answer;
    }


  }

}
