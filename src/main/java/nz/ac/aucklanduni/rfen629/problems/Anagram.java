package nz.ac.aucklanduni.rfen629.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Anagram {

    /*
     * LeetCode 242
     * https://leetcode.com/problems/valid-anagram/
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> occurrences = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char tChar = t.charAt(i);
            char sChar = s.charAt(i);
            occurrences.put(sChar, occurrences.getOrDefault(sChar, 0) + 1);
            occurrences.put(tChar, occurrences.getOrDefault(tChar, 0) - 1);
        }

        for (int sum : occurrences.values()) {
            if (sum != 0) {
                return false;
            }
        }

        return true;
    }

}
