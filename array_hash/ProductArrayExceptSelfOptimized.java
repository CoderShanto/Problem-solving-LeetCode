package array_hash;

public class ProductArrayExceptSelfOptimized {

    // Method to return product of all elements except itself
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;              // Length of the input array
        int[] res = new int[n];           // Result array to store final products

        // Step 1: Calculate prefix products (product of all elements before current index)
        res[0] = 1;                       // First element has no left product
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1]; // res[i] = product of all elements to the left of i
        }

        // Step 2: Calculate postfix products (product of all elements after current index)
        int postfix = 1;                  // Variable to keep track of product from the right side
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;            // Multiply current prefix product with right side product
            postfix *= nums[i];           // Update postfix for the next iteration
        }

        // Step 3: Return the result array
        return res;
    }

    // Main method to run the program
    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 6}; // Input array
        int[] result = productExceptSelf(nums); // Call the function

        // Print the output array
        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
