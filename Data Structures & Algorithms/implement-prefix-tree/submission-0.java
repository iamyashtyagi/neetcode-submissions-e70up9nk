
class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node start = root;
        for (char c : word.toCharArray()) {
            if (start.children == null) {
                start.children = new HashMap<>();
            }
            if (!start.children.containsKey(c)) {
                start.children.put(c, new Node());
            }
            start = start.children.get(c);
        }
        start.isEnd = true;
    }

    public boolean search(String word) {
        Node node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = traverse(prefix);
        return node != null;
    }

    private Node traverse(String str) {
        Node start = root;
        for (char c : str.toCharArray()) {
            if (start.children == null || !start.children.containsKey(c)) {
                return null;
            }
            start = start.children.get(c);
        }
        return start;
    }
}

class Node {
    Map<Character, Node> children;
    boolean isEnd;

    Node() {
        children = null; // consistent with your style
        isEnd = false;
    }
}
