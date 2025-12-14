package Sliding_window;

import java.util.HashSet;

public class LongestSubstringOptimized {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;

        //main sliding window loop
        while (right < s.length()) {
            char ch = s.charAt(right);

            // If duplicate found, move left pointer
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s)); // Output: 3
    }
}
