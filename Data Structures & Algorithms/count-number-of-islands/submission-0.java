class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;         // rows
        int n = grid[0].length;      // cols
        boolean[][] visited = new boolean[m][n];

        int numIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    numIsland++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return numIsland;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        // bounds + visited + water check
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (visited[x][y] || grid[x][y] != '1') return;

        visited[x][y] = true;

        // explore 4 directions
        dfs(grid, visited, x + 1, y);
        dfs(grid, visited, x - 1, y);
        dfs(grid, visited, x, y + 1);
        dfs(grid, visited, x, y - 1);
    }
}

