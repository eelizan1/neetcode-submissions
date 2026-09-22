class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_map = {} 
        result = []

        for s in strs: 
            anagram_key = ''.join(sorted(s))
            if not anagram_key in anagram_map: 
                anagram_map[anagram_key] = [s]
            else: 
                anagram_map[anagram_key].append(s)

        for values in anagram_map.values(): 
            result.append(values)
        
        return result 
        
        