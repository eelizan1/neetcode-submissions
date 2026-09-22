class Solution {
    private String DELIMETETER = "#"; 

    // 4#hello5#world
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 

        for (String word : strs) {
            String length = String.valueOf(word.length()); 
            sb.append(length); 
            sb.append("#"); 
            sb.append(word); 
        }

        return sb.toString(); 
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            StringBuilder stringLength = new StringBuilder();
            
            while (str.charAt(i) != '#') {
                stringLength.append(str.charAt(i));
                i++;
            }
            i++; // Move past the '#'

            int length = Integer.parseInt(stringLength.toString());
            String word = str.substring(i, i + length);
            res.add(word);

            i += length; // Move i to the next encoded string
        }

        return res;
    }

}
