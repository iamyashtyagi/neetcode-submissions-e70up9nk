class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1) return false;
        return findInRow(matrix[row], target);
    }

    private int findRow(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;

        while (top <= bottom) {
            int mid = (top + bottom) / 2;

            if (matrix[mid][0] <= target &&
                matrix[mid][matrix[0].length - 1] >= target) {
                return mid;
            } else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return -1;
    }

    private boolean findInRow(int[] row, int target) {
        int left = 0, right = row.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) return true;
            else if (row[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}