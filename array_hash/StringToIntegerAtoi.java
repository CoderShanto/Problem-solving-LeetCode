package array_hash;


public class StringToIntegerAtoi {

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, i = 0;

        // Check sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        int num = 0;

        // Convert characters to number
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Overflow check
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }

    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "91283472332";  // overflow

        System.out.println(myAtoi(s1)); // 42
        System.out.println(myAtoi(s2)); // -42
        System.out.println(myAtoi(s3)); // 4193
        System.out.println(myAtoi(s4)); // 2147483647 (MAX)
    }
}
