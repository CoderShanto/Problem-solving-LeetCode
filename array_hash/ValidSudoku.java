package array_hash;

public class ValidSudoku {

    // Function to check if the board is valid
    public static boolean isValidSudoku(char[][] board) {
        // Loop through every cell in the 9x9 Sudoku board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // If the cell is not empty ('.'), we validate it
                if (board[i][j] != '.') {
                    char num = board[i][j];

                    // Check the entire row for duplicate
                    for (int col = 0; col < 9; col++) {
                        if (col != j && board[i][col] == num) {
                            return false; // duplicate found in row
                        }
                    }

                    // Check the entire column for duplicate
                    for (int row = 0; row < 9; row++) {
                        if (row != i && board[row][j] == num) {
                            return false; // duplicate found in column
                        }
                    }

                    // Check the 3x3 sub-box for duplicate
                    int startRow = (i / 3) * 3;  // Top-left row index of the box
                    int startCol = (j / 3) * 3;  // Top-left column index of the box
                    for (int r = startRow; r < startRow + 3; r++) {
                        for (int c = startCol; c < startCol + 3; c++) {
                            if ((r != i || c != j) && board[r][c] == num) {
                                return false; // duplicate found in sub-box
                            }
                        }
                    }
                }
            }
        }
        // If no duplicates found, board is valid
        return true;
    }

    // Separate main() just to test the function
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
