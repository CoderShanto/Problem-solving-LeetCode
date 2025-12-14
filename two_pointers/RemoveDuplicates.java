package two_pointers;

import java.util.Arrays;

public class RemoveDuplicates {

    // Function to remove duplicates in-place
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0; // pointer to place the next unique element

        for (int current = 1; current < nums.length; current++) {
            if (nums[current] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[current];
            }
        }

        // Return the number of unique elements
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}


