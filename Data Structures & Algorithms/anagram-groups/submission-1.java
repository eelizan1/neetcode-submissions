class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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

        return new ArrayList<>(map.values());
    }
}
