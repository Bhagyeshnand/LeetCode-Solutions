class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        char[] array = word.toCharArray();
        TrieNode node = root;
        for (char ch : array) {
            TrieNode nextNode = node.nodes[ch - 'a'];
            if (nextNode == null) {
                nextNode = new TrieNode();
                node.nodes[ch - 'a'] = nextNode;
            }
            node = nextNode;
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] array = word.toCharArray();
        return search(array, 0, root);
    }

    private boolean search(char[] array, int index, TrieNode node) {
        if (index == array.length) {
            if (node.isWord) {
                return true;
            }
            return false;
        }
        char ch = array[index];
        if (ch != '.') {
            TrieNode nextNode = node.nodes[ch - 'a'];
            if (nextNode != null) {
                return search(array, index + 1, nextNode);
            }
        } else {
            for (TrieNode nextNode : node.nodes) {
                if (nextNode == null) {
                    continue;
                }
                if (search(array, index + 1, nextNode)) {
                    return true;
                }
            }
        }
        return false;
    }

    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */