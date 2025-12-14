package two_pointers;

import java.util.*;

public class FourSum {

    /**
     * Finds all unique quadruplets in nums that sum to target.
     * @param nums Input array
     * @param target Target sum
     * @return List of quadruplets
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        // Sort the array to use two-pointer approach and skip duplicates easily
        Arrays.sort(nums);

        int n = nums.length;

        // First loop for the first number
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            // Second loop for the second number
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates

                int left = j + 1; // pointer for the third number
                int right = n - 1; // pointer for the fourth number

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Found a quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for the third number
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // need a bigger sum
                    } else {
                        right--; // need a smaller sum
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,3,-3,1,0};
        int target1 = 3;
        System.out.println(fourSum(nums1, target1)); // [[-3, 0, 3, 3], [-3, 1, 2, 3]]

        int[] nums2 = {1,-1,1,-1,1,-1};
        int target2 = 2;
        System.out.println(fourSum(nums2, target2)); // [[-1, 1, 1, 1]]
    }
}
