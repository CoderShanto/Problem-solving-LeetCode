package two_pointers;

public class MinTimeColorfulRope {

    /**
     * Returns minimum time to make the rope colorful.
     * @param colors String representing balloon colors
     * @param neededTime Time needed to remove each balloon
     * @return Minimum total time
     */
    public static int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.length();
        int maxTime = neededTime[0]; // max time in current consecutive group

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // If same color as previous, we need to remove one
                totalTime += Math.min(maxTime, neededTime[i]);
                // Keep the balloon with the higher removal time
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                // Reset maxTime for new color group
                maxTime = neededTime[i];
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        String colors1 = "abaac";
        int[] neededTime1 = {1,2,3,4,5};
        System.out.println(minCost(colors1, neededTime1)); // 3

        String colors2 = "abc";
        int[] neededTime2 = {1,2,3};
        System.out.println(minCost(colors2, neededTime2)); // 0

        String colors3 = "aabaa";
        int[] neededTime3 = {1,2,3,4,1};
        System.out.println(minCost(colors3, neededTime3)); // 2
    }
}
