class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = set()
        start = 0
        longest = 0

        for end in range(len(s)): 
            end_char = s[end]

            while end_char in window: 
                start_char = s[start]
                window.remove(start_char)
                start += 1
            
            window.add(end_char)
            
            longest = max(longest, len(window))
        
        return longest 


        