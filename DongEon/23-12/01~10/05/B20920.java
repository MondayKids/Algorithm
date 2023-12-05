package baekjoon.backjoon12.day0110.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
영단어 암기는 괴로워
https://www.acmicpc.net/problem/20920
 */

public class B20920 {

  static int n, m;
  static Map<String, Integer> wordsInput;
  static List<Word> words;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    wordsInput = new HashMap<>();

    while(n-- > 0) {
      String word = br.readLine().trim();
      if(word.length() >= m) {
        wordsInput.put(word, wordsInput.getOrDefault(word, 0) + 1);
      }
    }

    words = new ArrayList<>();
    for(String word : wordsInput.keySet()) {
      words.add(new Word(word, wordsInput.get(word)));
    }

    Collections.sort(words);

    StringBuilder sb = new StringBuilder();
    for(Word word : words) {
      sb.append(word.word).append("\n");
    }

    System.out.println(sb);



  }

  public static class Word implements Comparable<Word> {
    String word;
    int count;

    Word(String word, int count) {
      this.word = word;
      this.count = count;
    }

    // 자주 나오는 단어 앞
    // 해당 단어 길이가 길수록 앞
    // 알파벳 사전 순으로 앞
    public int compareTo(Word w) {
      // 자주 나오는 단어 앞
      if(this.count != w.count) {
        return w.count - this.count;
      }

      // 단어 길이가 길수록 앞
      if(this.word.length() != w.word.length()) {
        return w.word.length() - this.word.length();
      }

      // 알파벳 순으로 정렬
      return this.word.compareTo(w.word);
    }

  }

}
