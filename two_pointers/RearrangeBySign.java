package two_pointers;

import java.util.*;

public class RearrangeBySign {

    /**
     * Rearranges the array so that positives and negatives alternate,
     * starting with a positive number.
     * @param nums Input array
     * @return Modified array with alternating signs
     */
    public static int[] rearrange(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positives and negatives while preserving order
        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        int p = 0, q = 0;
        // Fill result array alternately starting with positive
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { // even index → positive
                result[i] = pos.get(p++);
            } else {          // odd index → negative
                result[i] = neg.get(q++);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrange(nums1))); // [3, -2, 1, -5, 2, -4]

        int[] nums2 = {-1,1};
        System.out.println(Arrays.toString(rearrange(nums2))); // [1, -1]
    }
}
