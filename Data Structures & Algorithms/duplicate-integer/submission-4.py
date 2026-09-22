class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        number_set = set() 
        for number in nums: 
            if number in number_set: 
                return True
            else: 
                number_set.add(number)
        return False 
        