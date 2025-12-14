package Sliding_window;

import java.util.HashMap;

public class ContainsDuplicateOptimized {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        // value -> last index

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);

                if (i - lastIndex <= k) {
                    return true;
                }
            }

            // Update latest index
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 2};
        int k = 1;

        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println(result); // false
    }
}
//time o(n)
//space o(n)