package array_hash;

import java.util.Arrays;

public class VowelString {

    public static boolean isVowelString(String word) {
        if(word.length() == 0) return false;//. খালি string হলে vowel string না
        char start = Character.toLowerCase(word.charAt(0));//word-এর প্রথম অক্ষর বের করা....Character.toLowerCase → বড় হাতের অক্ষর হলেও ছোট করে ফেলে

        char end = Character.toLowerCase(word.charAt(word.length()-1));
        return "aeiou".indexOf(start) != -1 && "aeiou".indexOf(end) != -1;
    }

    public static int[] countVowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];

        for(int q = 0; q < queries.length; q++) {
            int li = queries[q][0];
            int ri = queries[q][1];
            int count = 0;

            for(int i = li; i <= ri; i++) {
                if(isVowelString(words[i])) {
                    count++;
                }
            }
            ans[q] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"aba", "ede", "es"};
        int[][] queries = {{0,2}, {0,1}, {2,2}};

        int[] ans = countVowelStrings(words, queries);
        System.out.println(Arrays.toString(ans));
    }
}
/*
class Solution {

    boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;
        int[] prefix = new int[n + 1];   // prefix sum array

        // Step 1: prefix sum তৈরি
        for (int i = 0; i < n; i++) {
            String w = words[i];
            char start = Character.toLowerCase(w.charAt(0));
            char end = Character.toLowerCase(w.charAt(w.length() - 1));

            int isVowelString = (isVowel(start) && isVowel(end)) ? 1 : 0;

            prefix[i + 1] = prefix[i] + isVowelString;
        }

        // Step 2: প্রতিটি query কে O(1) এ answer
        int qn = queries.length;
        int[] ans = new int[qn];

        for (int q = 0; q < qn; q++) {
            int li = queries[q][0];
            int ri = queries[q][1];

            ans[q] = prefix[ri + 1] - prefix[li];
        }

        return ans;
    }
}

* */
