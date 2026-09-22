class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>(); 
        
        if (digits.length() == 0) return res; 

        HashMap<Character, String> map = new HashMap<>(); 
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(res, digits, 0, new StringBuilder(), map); 

        return res; 
    }

    private void backtrack(List<String> res, String digits, int index, StringBuilder curr, HashMap<Character, String> map) {
        if (curr.length() == digits.length()) {
            res.add(new String(curr)); 
            return; 
        }

        String letters = map.get(digits.charAt(index)); 
        for (char c : letters.toCharArray()) {
            curr.append(c); 
            backtrack(res, digits, index + 1, curr, map); 
            curr.deleteCharAt(curr.length() - 1); 
        }
    }
}
