class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False 

        sorted_s = ''.join(sorted(s))
        sorted_t = ''.join(sorted(t))

        if sorted_s != sorted_t: return False

        return True