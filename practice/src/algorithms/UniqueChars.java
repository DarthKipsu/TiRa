package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueChars {
  
  //Implement an algorithm to determine if a string has all unique characters.

  public boolean hasUniqueChars(String word) {
    // time complexity: O(n)
    // space complexity: O(n)
    Set<Character> characters = new HashSet<Character>();
    for (int i = 0; i < word.length(); i++) {
      if (characters.contains(word.charAt(i))) return false;
      characters.add(word.charAt(i));
    }
    return true;
  }
  
  //What if you can not use additional data structures?
  
  public boolean hasUniqueCharsNoDS(String word) {
    // time complexity: O(n^2)
    // space complexity: O(1)
    for (int i = 0; i < word.length(); i++) {
      char letter = word.charAt(i);
      for (int j = i + 1; j < word.length(); j++) {
        if (letter == word.charAt(j)) return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    UniqueChars uc = new UniqueChars();
    
    System.out.println(uc.hasUniqueChars("some word with duplicates"));
    System.out.println(uc.hasUniqueChars("no duplicates"));
    
    System.out.println(uc.hasUniqueCharsNoDS("some word with duplicates"));
    System.out.println(uc.hasUniqueCharsNoDS("no duplicates"));
  }
}