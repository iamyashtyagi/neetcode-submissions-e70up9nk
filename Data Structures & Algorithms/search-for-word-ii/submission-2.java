class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // store complete word
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return;
        }

        char c = board[i][j];
        if(c == '#' || node.children[c - 'a'] == null){
            return;
        }

        node = node.children[c - 'a'];

        if(node.word != null){
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[i][j] = '#';

        dfs(board, i+1, j, node, result);
        dfs(board, i-1, j, node, result);
        dfs(board, i, j+1, node, result);
        dfs(board, i, j-1, node, result);

        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }
}