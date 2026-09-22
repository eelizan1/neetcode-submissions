class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>(); 
        Set<String> visited = new HashSet<>(); 
        Trie trie = new Trie(); 

        for (String word : words) {
            trie.addWord(word); 
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, trie.root, result, visited, new StringBuilder()); 
            }
        }

        return result; 
    }

    private void dfs(char[][] board, int i, int j, TrieNode trieNode, List<String> result, Set<String> visited, StringBuilder sb) {
        String key = i + "," + j; 
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited.contains(key)) return; 
        if (!trieNode.children.containsKey(board[i][j])) return; 

        visited.add(key); 
        sb.append(board[i][j]); 
        trieNode = trieNode.children.get(board[i][j]); 

        if (trieNode.isWord) {
            result.add(sb.toString()); 
            trieNode.isWord = false; 
        }

        dfs(board, i + 1, j, trieNode, result, visited, sb); 
        dfs(board, i - 1, j, trieNode, result, visited, sb); 
        dfs(board, i, j + 1, trieNode, result, visited, sb); 
        dfs(board, i, j - 1, trieNode, result, visited, sb); 

        sb.deleteCharAt(sb.length() - 1);
        visited.remove(key); 
    }
}

class Trie {
    TrieNode root = new TrieNode(); 

    void addWord(String word) {
        TrieNode curr = root; 
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode()); 
            }

            curr = curr.children.get(c); 
        }

        curr.isWord = true; 
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>(); 
    boolean isWord;  
}
