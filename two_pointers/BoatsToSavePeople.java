package two_pointers;

import java.util.Arrays;

public class BoatsToSavePeople {

    // Two-pointer method to calculate minimum boats
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort array by weight

        int left = 0;                 // Lightest person
        int right = people.length - 1; // Heaviest person
        int boats = 0;

        while (left <= right) {
            // If lightest + heaviest <= limit, pair them
            if (people[left] + people[right] <= limit) {
                left++;  // move lightest pointer
            }
            // Heaviest person always goes
            right--;     // move heaviest pointer
            boats++;     // one boat used
        }

        return boats;
    }

    public static void main(String[] args) {
        int[] people1 = {5, 1, 4, 2};
        int limit1 = 6;
        System.out.println("Minimum boats: " + numRescueBoats(people1, limit1)); // 2

        int[] people2 = {1, 3, 2, 3, 2};
        int limit2 = 3;
        System.out.println("Minimum boats: " + numRescueBoats(people2, limit2)); // 4
    }
}
//time: 0(n log n)
//space: o(1)