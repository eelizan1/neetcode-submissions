class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>(); 
        Trie trie = new Trie(); 

        for (String word : words) {
            trie.addWord(word); 
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, trie.root, result, new StringBuilder()); 
            }
        }

        return result; 
    }

    private void dfs(char[][] board, int i, int j, TrieNode trieNode, List<String> result, StringBuilder sb) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '#') return;

        char c = board[i][j];                       // capture BEFORE mutating
        if (!trieNode.children.containsKey(c)) return;

        board[i][j] = '#';
        sb.append(c);                               // use the saved char
        trieNode = trieNode.children.get(c);        // use the saved char

        if (trieNode.isWord) {
            result.add(sb.toString());
            trieNode.isWord = false;
        }

        dfs(board, i + 1, j, trieNode, result, sb);
        dfs(board, i - 1, j, trieNode, result, sb);
        dfs(board, i, j + 1, trieNode, result, sb);
        dfs(board, i, j - 1, trieNode, result, sb);

        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = c;                            // restore from the saved char
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
