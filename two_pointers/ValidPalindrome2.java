package two_pointers;

public class ValidPalindrome2 {
    public static void main(String[] args){
        String[] str = {"abca"}; // example where we can delete 'c'

        String s = str[0].toLowerCase(); // convert to lowercase
        String result = s.replaceAll("[^a-zA-Z0-9]", ""); // clean string

        int left = 0;
        int right = result.length() - 1;

        boolean isValid = true;

        while (left < right) {
            if (result.charAt(left) != result.charAt(right)) {
                // Try removing either left or right character
                isValid = isPalindromeRange(result, left + 1, right) ||
                        isPalindromeRange(result, left, right - 1);
                break;
            }
            left++;
            right--;
        }

        System.out.println("Can be palindrome after deleting at most 1 char? " + isValid);
    }

    private static boolean isPalindromeRange(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}