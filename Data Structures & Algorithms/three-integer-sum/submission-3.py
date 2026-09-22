class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        sorted_nums = sorted(nums)

        for i in range(len(sorted_nums)): 
            # duplicate checks
            if i > 0 and sorted_nums[i] == sorted_nums[i - 1]: continue 

            p1 = i + 1 
            p2 = len(sorted_nums) - 1

            while p1 < p2: 
                curr_sum = sorted_nums[i] + sorted_nums[p1] + sorted_nums[p2]

                if curr_sum == 0: 
                    result.append([sorted_nums[i], sorted_nums[p1], sorted_nums[p2]])
                    # duplicate checks
                    while p1 < p2 and sorted_nums[p1] == sorted_nums[p1 + 1]: p1 += 1
                    while p1 < p2 and sorted_nums[p2] == sorted_nums[p2 - 1]: p2 -= 1

                    p1 += 1
                    p2 -= 1

                elif curr_sum < 0: 
                    p1 += 1
                elif curr_sum > 0: 
                    p2 -= 1
        
        return result 