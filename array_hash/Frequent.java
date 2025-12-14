package array_hash;

import java.util.*;

public class Frequent {

    // Method to find the k most frequent elements
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count how many times each number appears
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Step 2: Create an array of lists (buckets)
        // Index = frequency, Value = list of numbers with that frequency
        // Maximum frequency can be nums.length (if all numbers are the same)
        List<Integer>[] freq = new List[nums.length + 1];

        // Initialize each bucket as an empty list
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Step 3: Place each number into its frequency bucket
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            freq[frequency].add(num);
        }

        // Step 4: Collect the top k frequent numbers from the end of the bucket array
        int[] res = new int[k];
        int index = 0;

        // Go from the most frequent numbers to the least
        for (int i = freq.length - 1; i >= 1; i--) {
            for (int n : freq[i]) {      // Get all numbers with frequency i
                res[index] = n;          // Add to result array
                index++;                 // Move to next position
                if (index == k) {        // Stop if we already got k elements
                    return res;
                }
            }
        }


        return res;
    }

    // ✅ Main method to test the program
    public static void main(String[] args) {
        Frequent fre = new Frequent();

        // Example input
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Call the function
        int[] result = fre.topKFrequent(nums, k);

        // Print result
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));
    }
}
