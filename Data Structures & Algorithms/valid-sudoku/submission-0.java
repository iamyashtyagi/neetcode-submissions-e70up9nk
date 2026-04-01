
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!sudokuCreated(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean sudokuCreated(char[][] board, int i, int j) {
        if (board[i][j] == '.') return true;

        return validateRowCol(board, i, j) && validateSquare(board, i, j);
    }

    private boolean validateSquare(char[][] board, int i, int j) {
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;

        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if (r == i && c == j) continue;
                if (board[r][c] == board[i][j]) return false;
            }
        }
        return true;
    }

    private boolean validateRowCol(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j]) return false;
            if (k != i && board[k][j] == board[i][j]) return false;
        }
        return true;
    }
}