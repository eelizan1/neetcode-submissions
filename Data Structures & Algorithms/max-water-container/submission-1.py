class Solution:
    def maxArea(self, heights: List[int]) -> int:
        p1 = 0
        p2 = len(heights) - 1
        max_height = 0

        while p1 < p2: 
            curr_length = p2 - p1
            curr_height = min(heights[p1], heights[p2])
            curr_area = curr_length * curr_height

            max_height = max(curr_area, max_height)

            if heights[p1] < heights[p2]: 
                p1 += 1
            else: 
                p2 -= 1
        
        return max_height