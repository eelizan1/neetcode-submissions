class Solution {

    // [neet, code] -> 4#neet4#code
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder(); 

        for (String str : strs) {
            encoded.append(String.valueOf(str.length())); 
            encoded.append("#"); 
            encoded.append(str); 
        }

        return encoded.toString(); 
    }

    // 4#neet4#code -> [neet, code]
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>(); 
        
        int i = 0; 
        while (i < str.length()) {
            // 1. find word length 
            String strLength = ""; 
            while (str.charAt(i) != '#') {
                strLength += str.charAt(i); 
                i++; 
            }

            i++; 
            // 2. form word 
            int wordLength = Integer.valueOf(strLength); 
            String word = str.substring(i, i + wordLength); 
            result.add(word); 

            // 3. increment i to new word 
            i = i + wordLength; 
        }

        return result; 
    }
}
