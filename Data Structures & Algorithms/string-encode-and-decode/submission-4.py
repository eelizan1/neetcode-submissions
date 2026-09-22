class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded = []
        for word in strs: 
            encoded.append(str(len(word))) # len must be string 
            encoded.append("#")
            encoded.append(word)
        
        return "".join(encoded)

    # "4#neet4#code"
    def decode(self, s: str) -> List[str]:
        result = [] 

        i = 0 
        while i < len(s): 
            strLength = []
            
            # find full number 
            while s[i] != "#": 
                strLength.append(s[i])
                i += 1
            i += 1

            length = int("".join(strLength))
            word = s[i: i + length]
            result.append(word)

            i = i + length

        return result

