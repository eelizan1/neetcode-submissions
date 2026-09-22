class Solution {
    List<String> output = new ArrayList<>(); 
    StringBuilder current = new StringBuilder(); 

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0); 
        return output; 
    }

    private void backtrack(int n, int open, int close) {
        if (open == n && close == n) {
            output.add(current.toString()); 
            return; 
        }

        if (open < n) {
            current.append('('); 
            backtrack(n, open + 1, close); 
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        if (close < open) {
            current.append(')'); 
            backtrack(n, open, close + 1); 
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}
