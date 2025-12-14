package array_hash;

public class MaxDistance {

    public static int maxDistance(java.util.List<java.util.List<Integer>> arrays) {

        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;

        for (int i = 1; i < arrays.size(); i++) {
            int currentMin = arrays.get(i).get(0);
            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);

            // Compare cross arrays
            result = Math.max(result, Math.abs(currentMax - globalMin));
            result = Math.max(result, Math.abs(globalMax - currentMin));

            // Update global min/max for next steps
            globalMin = Math.min(globalMin, currentMin);
            globalMax = Math.max(globalMax, currentMax);
        }

        return result;
    }

    public static void main(String[] args) {

        java.util.List<java.util.List<Integer>> arrays1 = java.util.Arrays.asList(
                java.util.Arrays.asList(1, 2, 3),
                java.util.Arrays.asList(4, 5),
                java.util.Arrays.asList(1, 2, 3)
        );

        java.util.List<java.util.List<Integer>> arrays2 = java.util.Arrays.asList(
                java.util.Arrays.asList(1),
                java.util.Arrays.asList(1)
        );

        System.out.println(maxDistance(arrays1));  // Output: 4
        System.out.println(maxDistance(arrays2));  // Output: 0
    }
}
