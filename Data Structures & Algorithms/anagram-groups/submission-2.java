class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); 

        for (String str : strs) {
            char[] keyChar = str.toCharArray(); 
            Arrays.sort(keyChar); 
            String anagramKey = new String (keyChar); 

            map.putIfAbsent(anagramKey, new ArrayList<>());
            map.get(anagramKey).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
