class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        int count = 0;

        int i = 0, j = 0;
        int turn = 0;

        while (count < row * col) {
            int right = col - 1 - turn;
            int bottom = row - 1 - turn;
            int left = turn;
            int top = turn;

            // move right
            for (j = left; j <= right && count < row * col; j++) {
                result.add(matrix[top][j]);
                count++;
            }

            // move down
            for (i = top + 1; i <= bottom && count < row * col; i++) {
                result.add(matrix[i][right]);
                count++;
            }

            // move left
            for (j = right - 1; j >= left && count < row * col; j--) {
                result.add(matrix[bottom][j]);
                count++;
            }

            // move up
            for (i = bottom - 1; i > top && count < row * col; i--) {
                result.add(matrix[i][left]);
                count++;
            }

            turn++;
        }
        return result;
    }
}
