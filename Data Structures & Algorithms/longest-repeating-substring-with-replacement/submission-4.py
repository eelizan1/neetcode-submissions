class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        start = 0
        longest = 0
        char_dict = {} 

        for end in range(len(s)): 
            end_char = s[end]
            char_dict[end_char] = char_dict.get(end_char, 0) + 1

            while (end - start + 1) - max(char_dict.values()) > k: 
                start_char = s[start]
                char_dict[start_char] = char_dict[start_char] - 1

                start += 1
            
            longest = max(longest, (end - start) + 1)

        return longest