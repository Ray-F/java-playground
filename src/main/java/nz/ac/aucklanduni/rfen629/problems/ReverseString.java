package nz.ac.aucklanduni.rfen629.problems;

public class ReverseString {

    /*
     * LeetCode 344
     * https://leetcode.com/problems/reverse-string/
     */
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char cur = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = cur;
        }
    }

}
