class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Set<String> prefix = new HashSet<>();
        
        for(String w : words){
            for(int i=1;i<=w.length();i++){
                prefix.add(w.substring(0,i));
            }
        }

        List<String> result = new ArrayList<>();
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                boolean[][] visited = new boolean[row][col];
                dfs(board, set, prefix, i, j, result, "", visited);
            }
        }
        return result;
    }

    private void dfs(char[][] board, Set<String> set, Set<String> prefix,
                     int i, int j,
                     List<String> result,
                     String wordCreated,
                     boolean[][] visited) {

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]){
            return;
        }

        wordCreated += board[i][j];

        // PRUNE HERE (this removes TLE)
        if(!prefix.contains(wordCreated)){
            return;
        }

        if(set.contains(wordCreated)){
            result.add(wordCreated);
            set.remove(wordCreated);
        }

        visited[i][j] = true;

        int[] dir_x = {1,0,0,-1};
        int[] dir_y = {0,1,-1,0};

        for(int k = 0; k < 4; k++){
            dfs(board, set, prefix,
                i + dir_x[k],
                j + dir_y[k],
                result,
                wordCreated,
                visited);
        }

        visited[i][j] = false;
    }
}