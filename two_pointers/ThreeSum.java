package two_pointers;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ThreeSum {

    public static void main(String[] args){

        ArrayList<Integer> d = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4));

        // Step 1: Sort
        Collections.sort(d);
        System.out.println("Sorted: " + d);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Step 2: Loop for each element as first number
        for (int i = 0; i < d.size(); i++) {

            // avoid duplicate first numbers
            if (i > 0 && d.get(i).equals(d.get(i - 1))) {
                continue;
            }

            int first = d.get(i);
            int target = -first;

            // Step 3: HashMap for pair (target - second)
            HashMap<Integer, Boolean> map = new HashMap<>();

            for (int j = i + 1; j < d.size(); j++) {
                int second = d.get(j);
                int third = target - second;

                if (map.containsKey(third)) {
                    // Triplet found
                    ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(first, second, third));
                    Collections.sort(triplet);

                    // avoid duplicate triplets
                    if (!result.contains(triplet)) {
                        result.add(triplet);
                    }
                }

                map.put(second, true);


            }
        }

        System.out.println("Triplets: " + result);
    }
}
