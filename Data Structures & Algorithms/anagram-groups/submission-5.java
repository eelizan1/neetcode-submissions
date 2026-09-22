class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); 
        List<List<String>> result = new ArrayList<>(); 

        for (String word : strs) {
            char[] wordChar = word.toCharArray(); 
            Arrays.sort(wordChar); 
            String key = new String(wordChar); 

            if (map.containsKey(key)) {
                map.get(key).add(word); 
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(word)));
            }
        }

        for (List<String> words : map.values()) {
            result.add(words); 
        }

        return result; 
    }
}
