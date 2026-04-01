class Solution {

    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(board[i][j] == word.charAt(0)){
                    if(wordCreated(board, i, j, word, 0)){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean wordCreated(char[][] board, int i, int j, String word, int index){

        // base case
        if(index == word.length())
            return true;

        // boundary + mismatch check
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length
           || board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '#';   // mark visited

        int[] dir_x = {0,0,1,-1};
        int[] dir_y = {1,-1,0,0};

        for(int k=0;k<4;k++){
            int ni = i + dir_x[k];
            int nj = j + dir_y[k];

            if(wordCreated(board, ni, nj, word, index + 1)){
                return true;
            }
        }

        board[i][j] = temp; // backtrack
        return false;
    }
}