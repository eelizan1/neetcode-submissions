class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sum_map = {} 

        for i in range(len(nums)): 
            compliment = target - nums[i]
            if compliment in sum_map: 
                return [sum_map.get(compliment), i]
            else: 
                sum_map[nums[i]] = i
        
        return [-1, -1]
