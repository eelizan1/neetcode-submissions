class Solution {

    // ["hello", "world"] -> 5#hello5#world
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 
        
        for (String str : strs) {
            int length = str.length(); 
            sb.append(String.valueOf(length)); 
            sb.append("#"); 
            sb.append(str); 
        }

        return sb.toString(); 
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>(); 

        int i = 0; 
        while (i < str.length()) {
            StringBuilder lenSb = new StringBuilder(); 
            while (str.charAt(i) != '#') {
                lenSb.append(str.charAt(i)); 
                i++; 
            }
            i++; 

            int wordLength = Integer.valueOf(lenSb.toString()); 
            String word = str.substring(i, i + wordLength); 

            res.add(word); 

            i = i + wordLength; 
        }

        return res; 
    }
}
