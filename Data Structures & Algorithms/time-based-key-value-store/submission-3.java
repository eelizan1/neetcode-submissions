class TimeMap {
    HashMap<String, List<Pair>> map; 

    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp); 
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>()); 
        }

        map.get(key).add(pair); 
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = map.get(key); 

        if (values == null) return ""; 

        return binarySearch(timestamp, values); 
    }

    private String binarySearch(int timestamp, List<Pair> values) {
        int left = 0; 
        int right = values.size() - 1; 
        String result = ""; 

        while (left <= right) {
            int middle = (left + right) / 2; 

            if (values.get(middle).time <= timestamp) {
                result = values.get(middle).value; 
                left = middle + 1; 
            } else {
                right = middle - 1; 
            }
        }

        return result; 
    }
}

class Pair {
    String value; 
    int time;

    public Pair() {}

    public Pair(String value, int time) {
        this.value = value; 
        this.time = time; 
    }
}
