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

        backtrack(res, new StringBuilder(), digits, 0, map); 

        return res; 
    }

    private void backtrack(List<String> res, StringBuilder sb, String digits, int index, HashMap<Character, String> map) {
        if (index == digits.length()) {
            res.add(new String(sb)); 
            return; 
        }

        String letters = map.get(digits.charAt(index)); 
        for (char c : letters.toCharArray()) {
            sb.append(c); 
            backtrack(res, sb, digits, index + 1, map); 
            sb.deleteCharAt(sb.length() - 1); 
        }
    }
}
