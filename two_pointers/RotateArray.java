package two_pointers;

import java.util.Arrays;

public class RotateArray {

    /**
     * Rotates the array to the right by k steps.
     * @param nums Input array
     * @param k Number of steps to rotate
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle k greater than array length

        if (k == 0) return; // no rotation needed

        // Step 1: Reverse the whole array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    /**
     * Helper function to reverse elements in the array from start to end indices.
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8};
        int k1 = 4;
        rotate(nums1, k1);
        System.out.println(Arrays.toString(nums1)); // [5,6,7,8,1,2,3,4]

        int[] nums2 = {1000,2,4,-3};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2)); // [4,-3,1000,2]
    }
}
