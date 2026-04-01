
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int rows = grid.length;
        int cols = grid[0].length;
        final int INF = 2147483647;

        Queue<Pair> q = new LinkedList<>();

        // enqueue all gates (0) as sources
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curDist = grid[cur.x][cur.y];
            for (int[] d : dirs) {
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) continue;
                if (grid[nx][ny] == -1) continue; // wall, skip

                int candidate = curDist + 1;
                if (grid[nx][ny] == INF || candidate < grid[nx][ny]) {
                    grid[nx][ny] = Math.min(grid[nx][ny], candidate);
                    q.add(new Pair(nx, ny));
                }
            }
        }

    }
}

class Pair {
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
