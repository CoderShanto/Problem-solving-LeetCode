package Sliding_window;

public class Main {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int target = 10;
        int[] nums = {2, 1, 5, 1, 5, 3};
        System.out.println(minSubArrayLen(target, nums)); // Output: 3
    }
}
//time==O(n)
//space==O(1)