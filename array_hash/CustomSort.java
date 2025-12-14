package array_hash;

public class CustomSort {

    public static String customSortString(String order, String s) {

        // Step-1: frequency count
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        // Step-2: add characters in the custom order
        for (char c : order.toCharArray()) {
            while (freq[c - 'a'] > 0) {
                result.append(c);
                freq[c - 'a']--;
            }
        }

        // Step-3: add remaining characters not in order
        for (char c = 'a'; c <= 'z'; c++) {
            while (freq[c - 'a'] > 0) {
                result.append(c);
                freq[c - 'a']--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String order = "xabfcg";
        String s = "bdca";

        String ans = customSortString(order, s);
        System.out.println(ans);  // Example output: abcd
    }
}
