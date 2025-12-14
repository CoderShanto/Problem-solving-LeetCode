package two_pointers;
import java.util.Arrays;
public class NumSubsequences {

    private static final int MOD = 1_000_000_007;

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        // Precompute powers of 2
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int ans = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans = (ans + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,5,6,7};
        int target1 = 9;
        System.out.println("Number of subsequences: " + numSubseq(nums1, target1)); // 4

        int[] nums2 = {3,3,6,8};
        int target2 = 10;
        System.out.println("Number of subsequences: " + numSubseq(nums2, target2)); // 6
    }
}
