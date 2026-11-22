class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>(); 
        HashMap<String, List<String>> map = new HashMap<>(); 

        for (String str : strs) {
            char[] strArray = str.toCharArray(); 
            Arrays.sort(strArray); 
            String sorted = new String(strArray); 

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>()); 
            }

            map.get(sorted).add(str); 
        }

        for (List<String> values : map.values()) {
            res.add(values); 
        }

        return res; 
    }
}
