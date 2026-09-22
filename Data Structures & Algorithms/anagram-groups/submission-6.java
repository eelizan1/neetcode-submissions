class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>(); 
        Map<String, List<String>> map = new HashMap<>(); 

        // build map 
        for (String str : strs) {
            // get key 
            char[] strChar = str.toCharArray(); 
            Arrays.sort(strChar); 
            String key = new String(strChar); 

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>()); 
            }

            map.get(key).add(str);
        }

        // build result 
        for (List<String> values : map.values()) {
            result.add(values); 
        }

        return result; 
    }
}
