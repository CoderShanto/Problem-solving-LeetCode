package array_hash;

public class ValidSudokuOptimal {

    // Function to check if the board is valid (optimal)
    public static boolean isValidSudoku(char[][] board) {
        // Create 9x9 boolean arrays to track digits 1-9
        boolean[][] row = new boolean[9][9];   // row[i][num] = true if num seen in row i
        boolean[][] col = new boolean[9][9];   // col[j][num] = true if num seen in column j
        boolean[][] box = new boolean[9][9];   // box[k][num] = true if num seen in box k

        // Traverse the board once
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') { // Only check filled cells
                    int num = c - '1'; // Convert '1'-'9' to 0-8

                    // Calculate box index: 0 to 8
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    // Check if num already seen in row, column, or box
                    if (row[i][num] || col[j][num] || box[boxIndex][num]) {
                        return false; // Duplicate found
                    }

                    // Mark this num as seen in row, column, and box
                    row[i][num] = true;
                    col[j][num] = true;
                    box[boxIndex][num] = true;
                }
            }
        }

        return true; // No duplicates found, board is valid
    }

    // Main method to test the function
    public static void main(String[] args) {
        char[][] board = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        boolean result = isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + result);
    }
}
