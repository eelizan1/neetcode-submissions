class TimeMap {

    HashMap<String, List<Pair>> map; 

    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>()); 
        }

        map.get(key).add(new Pair(value, timestamp)); 
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = map.getOrDefault(key, new ArrayList<>()); 
        // binary search with range 
        int left = 0; 
        int right = values.size() - 1; 
        String result = ""; 

        while (left <= right) {
            int mid = (left + right) / 2; 

            if (values.get(mid).timestamp == timestamp) {
                return values.get(mid).value; 
            } else if (values.get(mid).timestamp < timestamp) {
                result = values.get(mid).value; 
                left = mid + 1; 
            } else if (values.get(mid).timestamp > timestamp) {
                right = mid - 1; 
            }
        }

        return result; 
    }
}

class Pair {
    String value; 
    int timestamp; 

    Pair () {} 

    Pair (String value, int timestamp) {
        this.value = value; 
        this.timestamp = timestamp; 
    }
}
