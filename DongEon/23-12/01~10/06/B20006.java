package baekjoon.backjoon12.day0110.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
랭킹전 대기열
https://www.acmicpc.net/problem/20006
 */

public class B20006 {

  static int p; // 플레이어 수
  static int n; // 닉네임
  static int l; // 플레이어 레벨
  static int m; // 방 한개의 정원

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    p = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    List<Room> rooms = new ArrayList<>();

    while(p-- > 0) {
      st = new StringTokenizer(br.readLine());
      int level = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      Player player = new Player(level, name);
      boolean flag = false;

      for(Room room : rooms) {
        if(!room.isFull() && room.levelCheck(player.level)) {
          room.playersAdd(player);
          flag = true;
          break;
        }
      }

      if(!flag) {
        Room room = new Room(level);
        room.playersAdd(player);
        rooms.add(room);
      }
    }

    StringBuilder sb = new StringBuilder();
    for(Room room : rooms) {

      Collections.sort(room.players);

      if(room.isFull()) {
        sb.append("Started!");
      }
      else {
        sb.append("Waiting!");
      }
      sb.append("\n");

      for(Player player : room.players) {
        sb.append(player.level).append(" ").append(player.name).append("\n");
      }
    }

    System.out.println(sb);


  }

  public static class Room {
    int standardLevel;
    List<Player> players;
    Room(int level) {
      this.standardLevel = level;
      players = new ArrayList<>();
    }

    boolean levelCheck(int level) {
      if(standardLevel - 10 <= level && level <= standardLevel + 10) return true;
      return false;
    }

    void playersAdd(Player player) {
      players.add(player);
    }

    boolean isFull() {
      if(players.size() == m) return true;
      return false;
    }


  }

  public static class Player implements Comparable<Player> {
    int level;
    String name;

    Player(int level, String name) {
      this.level = level;
      this.name = name;
    }

    public int compareTo(Player player) {
      return this.name.compareTo(player.name);
    }
  }

}
