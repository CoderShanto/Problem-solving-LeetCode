package two_pointers;

public class ValidPalindrome {
    public static void main(String[] args){
        String[] str ={"A man, a plan, a canal: Panama"};


        boolean isPalindrome = true;

        String s = str[0].toLowerCase(); // convert to lowercase
        System.out.println(s);

        String result = s.replaceAll("[^a-zA-Z]","");
        System.out.println(result);

        int left = 0;
        int right = result.length()-1;


        while(left<right){
            if (result.charAt(left) != result.charAt(right)){
                isPalindrome = false;
            }
            left++;
            right--;
        }
        System.out.println("Is palindrome? " + isPalindrome);

    }
}
