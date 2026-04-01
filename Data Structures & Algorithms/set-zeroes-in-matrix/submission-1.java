class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: check first column
        for (int i = 0; i < R; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 1: check first row
        for (int j = 0; j < C; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: mark rows & columns
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 3: zero based on markers
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: zero first column
        if (firstColZero) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }

        // Step 4: zero first row
        if (firstRowZero) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
