import java.util.*;

public class FoodRatingsTest {

    static class FoodRatings {
        private Map<String, String> foodToCuisine;
        private Map<String, Integer> foodToRating;
        private Map<String, TreeSet<Food>> cuisineMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodToCuisine = new HashMap<>();
            foodToRating = new HashMap<>();
            cuisineMap = new HashMap<>();

            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];

                foodToCuisine.put(food, cuisine);
                foodToRating.put(food, rating);

                cuisineMap.putIfAbsent(cuisine, new TreeSet<>());
                cuisineMap.get(cuisine).add(new Food(food, rating));
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodToCuisine.get(food);
            int oldRating = foodToRating.get(food);

            TreeSet<Food> set = cuisineMap.get(cuisine);
            set.remove(new Food(food, oldRating)); // remove old entry
            set.add(new Food(food, newRating));    // add new entry

            foodToRating.put(food, newRating);    // update rating
        }

        public String highestRated(String cuisine) {
            return cuisineMap.get(cuisine).first().name;
        }

        static class Food implements Comparable<Food> {
            String name;
            int rating;
            Food(String n, int r) { name = n; rating = r; }

            public int compareTo(Food other) {
                if (this.rating != other.rating) return other.rating - this.rating; // descending
                return this.name.compareTo(other.name); // ascending lexicographically
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Food)) return false;
                Food f = (Food) o;
                return this.name.equals(f.name) && this.rating == f.rating;
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, rating);
            }
        }
    }

    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);

        System.out.println(foodRatings.highestRated("korean"));   // kimchi
        System.out.println(foodRatings.highestRated("japanese")); // ramen

        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese")); // sushi

        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese")); // ramen
    }
}
