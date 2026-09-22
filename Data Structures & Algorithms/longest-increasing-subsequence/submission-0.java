class Solution {
    public int lengthOfLIS(int[] nums) {
        return maxIncreaseSub(nums, 0, Integer.MIN_VALUE, new HashMap<>()); 
    }

    public static int maxIncreaseSub(int[] numbers, int index, int prev, HashMap<String, Integer> memo) {
        if (index == numbers.length) return 0; 

        String key = index + "," + prev; 
        if (memo.containsKey(key)) return memo.get(key); 

        int current = numbers[index]; 
        int[] decisionVals = new int[2]; 

        int dontTakeCurrent = maxIncreaseSub(numbers, index + 1, prev, memo); 
        decisionVals[0] = dontTakeCurrent; 

        if (current > prev) {
            int takeCurrent = maxIncreaseSub(numbers, index + 1, current, memo) + 1; 
            decisionVals[1] = takeCurrent; 
        }

        memo.put(key, Math.max(decisionVals[0], decisionVals[1]));
        return memo.get(key);
    }
}
