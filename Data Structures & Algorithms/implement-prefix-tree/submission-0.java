class PrefixTree {
    private TrieNode root; 

    public PrefixTree() {
         root = new TrieNode(); 
    }

    public void insert(String word) {
        TrieNode currNode = root; 
        for (char c : word.toCharArray()) {
            if (!currNode.children.containsKey(c)) {
                currNode.children.put(c, new TrieNode()); 
            }

            currNode = currNode.children.get(c); 
        }

        currNode.isWord = true; 
    }

    public boolean search(String word) {
        TrieNode currNode = root; 
        for (char c : word.toCharArray()) {
            if (!currNode.children.containsKey(c)) return false; 

            currNode = currNode.children.get(c); 
        }

        return currNode.isWord; 
    }

    public boolean startsWith(String prefix) {
        TrieNode currNode = root; 
        for (char c : prefix.toCharArray()) {
            if (!currNode.children.containsKey(c)) return false; 

            currNode = currNode.children.get(c);
        }

        return true; 
    }
}

class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>(); 
    boolean isWord = false; 
}
