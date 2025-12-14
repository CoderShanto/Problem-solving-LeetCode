package array_hash;

public class SmallestCommonElement {

    public static int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Use a hash array to count frequency of each element (elements <= 10^4)
        int maxVal = 10001; // assuming elements <= 10^4
        int[] count = new int[maxVal];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count[mat[i][j]]++;
            }
        }

        // Find the smallest element that appears in all rows
        for (int val = 1; val < maxVal; val++) {
            if (count[val] == m) return val;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1,2,3,4,5},
                {2,4,5,8,10},
                {3,5,7,9,11},
                {1,3,5,7,9}
        };

        int[][] mat2 = {
                {1,2,3},
                {2,3,4},
                {2,3,5}
        };

        System.out.println("Smallest common element in mat1: " + smallestCommonElement(mat1)); // 5
        System.out.println("Smallest common element in mat2: " + smallestCommonElement(mat2)); // 2
    }
}
