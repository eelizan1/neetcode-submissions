class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>(); 
        Map<String, List<String>> map = new HashMap<>(); 

        for (String str : strs) {
            char[] keyChar = str.toCharArray(); 
            Arrays.sort(keyChar); 
            String anagramKey = new String (keyChar); 

            if (map.containsKey(anagramKey)) {
                map.get(anagramKey).add(str); 
            } else {
                List<String> list = new ArrayList<>(); 
                list.add(str); 
                map.put(anagramKey, list); 
            }
        }

        for (Map.Entry<String, List<String> > entry : map.entrySet()) {
            res.add(entry.getValue()); 
        }

        return res; 
    }
}
