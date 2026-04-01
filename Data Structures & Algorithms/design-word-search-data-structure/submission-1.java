public class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
                node.children[idx].ch = c;
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int pos, TrieNode node) {
        if (node == null) return false;
        if (pos == word.length()) return node.isEnd;

        char c = word.charAt(pos);
        if (c == '.') {
            // try all children
            for (int i = 0; i < 26; i++) {
                TrieNode child = node.children[i];
                if (child != null && dfsSearch(word, pos + 1, child)) return true;
            }
            return false;
        } else {
            TrieNode child = node.children[c - 'a'];
            return child != null && dfsSearch(word, pos + 1, child);
        }
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        char ch; // optional: stores the char for debugging if you like
    }

}
