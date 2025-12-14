package Sliding_window;

public class PermutationInStringOptimized {

    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < n; right++) {
            //right যেখানে আছে, সেই অক্ষরটাকে আমরা window এর frequency array তে যোগ করছি।
            window[s2.charAt(right) - 'a']++;

            // Keep window size equal to s1
            if (right - left + 1 > m) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare when window size matches
            if (matches(s1Count, window)) {
                return true;
            }
        }

        return false;
    }

    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "lecabee"));  // true
        System.out.println(checkInclusion("abc", "lecaabee")); // false
    }
}
//time-->O(n)
//space-->O(1)