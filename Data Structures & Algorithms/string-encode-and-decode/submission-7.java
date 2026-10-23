class Solution {

    // "hello" "world" -> 5#hello5#world
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(String.valueOf(str.length())); 
            sb.append("#"); 
            sb.append(str); 
        }

        return sb.toString(); 
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>(); 

        int i = 0; 
        while (i < str.length()) {
            StringBuilder strLen = new StringBuilder(); 

            while(str.charAt(i) != '#') {
                strLen.append(str.charAt(i)); 
                i++; 
            }
            i++; 

            int length = Integer.parseInt(strLen.toString()); 
            String word = str.substring(i, i + length); 
            list.add(word); 

            i = i + length; 
        }

        return list; 
    }
}
