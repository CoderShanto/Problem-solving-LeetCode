import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PivotArray {

    /**
     * Rearranges nums around the pivot.
     * Elements less than pivot come first, then equal, then greater.
     * Relative order of <pivot and >pivot elements is preserved.
     *
     * @param nums Input array
     * @param pivot Pivot value
     * @return Rearranged array
     */
    public static int[] pivotArray(int[] nums, int pivot) {
        // Lists to store elements based on comparison with pivot
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        // Classify each element into the correct list
        for (int num : nums) {
            if (num < pivot) less.add(num);
            else if (num == pivot) equal.add(num);
            else greater.add(num);
        }

        // Merge the three lists back into the original array
        int index = 0;

        for (int num : less) nums[index++] = num;
        for (int num : equal) nums[index++] = num;
        for (int num : greater) nums[index++] = num;

        return nums;
    }

    // Test the code
    public static void main(String[] args) {
        int[] nums1 = {9,12,5,10,14,3,10};
        int pivot1 = 10;
        System.out.println(Arrays.toString(pivotArray(nums1, pivot1))); // [9, 5, 3, 10, 10, 12, 14]

        int[] nums2 = {-3,4,3,2};
        int pivot2 = 2;
        System.out.println(Arrays.toString(pivotArray(nums2, pivot2))); // [-3, 2, 4, 3]
    }
}
