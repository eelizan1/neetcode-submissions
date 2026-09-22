class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>(); 

        if (digits.length() == 0) return result;  

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(result, digits, 0, map, new StringBuilder()); 
        return result; 
    }

    public void backtrack(List<String> result, String digits, int index, HashMap<Character, String> map, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString()); 
            return; 
        }

        char digit = digits.charAt(index); 
        for (char c : map.get(digit).toCharArray()) {
            current.append(c); 
            backtrack(result, digits, index + 1, map, current); 
            current.deleteCharAt(current.length() - 1); 
        }
    }
}
