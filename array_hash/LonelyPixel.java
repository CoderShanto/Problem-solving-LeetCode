package array_hash;

public class LonelyPixel {

    public static int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Count black pixels in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int lonely = 0;

        // Check for lonely black pixels
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    lonely++;
                }
            }
        }

        return lonely;
    }

    public static void main(String[] args) {
        char[][] picture1 = {
                {'W','W','B'},
                {'W','B','W'},
                {'B','W','W'}
        };

        char[][] picture2 = {
                {'B','B','B'},
                {'B','B','W'},
                {'B','B','B'}
        };

        System.out.println("Lonely Pixels in picture1: " + findLonelyPixel(picture1)); // Output: 3
        System.out.println("Lonely Pixels in picture2: " + findLonelyPixel(picture2)); // Output: 0
    }
}
