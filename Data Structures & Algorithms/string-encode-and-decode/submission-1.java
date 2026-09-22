class Solution {

    // [hello, world] -> 4#hello5#world
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String word : strs) {
            String length = String.valueOf(word.length()); 
            encoded.append(length); 
            encoded.append("#"); 
            encoded.append(word); 
        }

        return encoded.toString(); 
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>(); 

        int i = 0; 
        while (i < str.length()) {
            String strLength = ""; 
            while (str.charAt(i) != '#') {
                strLength += str.charAt(i); 
                i++; 
            }

            i++; // skip delimeter 
            int wordLength = Integer.valueOf(strLength); 
            String word = str.substring(i, i + wordLength); 

            i = i + wordLength; 

            result.add(word); 
        }

        return result; 
    }
}
