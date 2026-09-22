class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); 
        List<List<String>> result = new ArrayList<>(); 

        for (String str : strs) {
            char[] strChar = str.toCharArray(); 
            Arrays.sort(strChar); 
            String key = new String(strChar); 

            if (map.containsKey(key)) {
                map.get(key).add(str); 
            } else {
                List<String> list = new ArrayList<>(); 
                list.add(str); 
                map.put(key, list); 
            }
        }

        for (List<String> values : map.values()) {
            result.add(values); 
        }

        return result; 
    }
}
