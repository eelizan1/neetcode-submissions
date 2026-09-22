class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)
        max_streak = 0 

        for num in nums: 
            copy_num = num 
            curr_streak = 1 
            while (copy_num + 1) in nums_set: 
                curr_streak += 1
                copy_num += 1 

            max_streak = max(max_streak, curr_streak)
        
        return max_streak 
            


        