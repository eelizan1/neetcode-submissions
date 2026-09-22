class WordDictionary {
    TrieNode root; 

    public WordDictionary() {
        root = new TrieNode(); 
    }

    public void addWord(String word) {
        TrieNode current = root; 

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode()); 
            }

            current = current.children.get(c); 
        }

        current.isWord = true; 
    }

    public boolean search(String word) {
        return searchInRoot(word, root); 
    }

    private boolean searchInRoot(String word, TrieNode current) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); 

            if (c == '.') {
                for (char ch : current.children.keySet()) {
                    TrieNode nextCurrent = current.children.get(ch); 
                    if (searchInRoot(word.substring(i + 1), nextCurrent)) return true; 
                }

                return false; 
            } else {
                if (!current.children.containsKey(c)) return false; 
                current = current.children.get(c); 
            }
        }

        return current.isWord; 
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>(); 
    boolean isWord = false; 
}