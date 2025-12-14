package two_pointers;

public class StringCompression {

    /**
     * Compresses the input char array in-place.
     * @param chars Input character array
     * @return New length of compressed array
     */
    public static int compress(char[] chars) {
        int write = 0; // position to write compressed chars
        int i = 0; // read pointer

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count consecutive occurrences of currentChar
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // length of compressed string
    }

    public static void main(String[] args) {
        char[] chars1 = {'a','a','a','a','a','a','a','a','a','a','a'};
        System.out.println(compress(chars1)); // 3 → ["a","1","1"]

        char[] chars2 = {'A'};
        System.out.println(compress(chars2)); // 1 → ["A"]

        char[] chars3 = {'1','1','2'};
        System.out.println(compress(chars3)); // 3 → ["1","2","2"]
    }
}
