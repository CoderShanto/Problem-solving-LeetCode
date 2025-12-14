package Sliding_window;

public class LongestRepeatingCharacterReplacementOptimized {

    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];   // A-Z frequency
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // current character frequency বাড়ানো
            freq[s.charAt(right) - 'A']++;

            // window-এ সবচেয়ে বেশি যে character আছে তার count
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // যদি window invalid হয় (k ছাড়িয়ে যায়)
            int windowSize = right - left + 1;
            int changesNeeded = windowSize - maxFreq;

            if (changesNeeded > k) {
                freq[s.charAt(left) - 'A']--; // left character বাদ
                left++; // window ছোট করা
            }

            // max length update
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AAABABB";
        int k = 1;

        System.out.println(characterReplacement(s, k)); // Output: 5
    }
}
//Time
//O(n) ✅
//Space
//O(1) ✅