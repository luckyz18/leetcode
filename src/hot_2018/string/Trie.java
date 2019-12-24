package hot_2018.string;

/**
 * 实现 trie树
 * 前缀树
 */
class Trie {
    class TrieNode {
        int path;  // 不能说是入度出度把  就是经过几次算几次  经过节点的前缀数
        int end;
        TrieNode[] map;

        public TrieNode() {
            this.map = new TrieNode[26];
        }
    }

    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        //node.path++;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return true;
    }

    public int prefixNumber(String prefix) {
        if (prefix == null) {
            return 0;
        }
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = c - 'a';
            if (node.map[index] == null) {
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }

    public void delete(String s) {
        if (s == null) {
            return;
        }
        if(search(s)) {
            char[] chars = s.toCharArray();
            TrieNode node = root;

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int index = c - 'a';
                if (node.map[index] == null) {
                    return;
                }
                if (node.map[index].path-- == 1) {
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }
    }
}
