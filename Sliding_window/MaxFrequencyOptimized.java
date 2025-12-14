package Sliding_window;

public class MaxFrequencyOptimized {

    public static int maxFrequency(int[] nums, int k) {

        //Sliding window তৈরি করো left = 0 → window এর শুরু;;total = 0 → window এর sum;;maxFreq = 1 → শুরুতে 1 ধরে নিই
        int n = nums.length;
        int maxFreq = 1;

        int left = 0;
        long total = 0;
//আমরা window এর শেষ element right দিয়ে loop চালাই
        for (int right = 0; right < nums.length; right++) {
            total += nums[right]; // add current number to window sum
//Window valid কি না check করো
            while ((long) nums[right] * (right - left + 1) - total > k) {
                total -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);


        }
        return maxFreq;

    }


    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 5;
        System.out.println(maxFrequency(nums, k)); // Output: 3
    }

}
