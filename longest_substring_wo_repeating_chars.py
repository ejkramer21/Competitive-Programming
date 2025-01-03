class longest_substring_wo_repeating_chars:
    def lengthOfLongestSubstring(self, s: str) -> int:
        '''
        BF: check every substring - O(n^2)

        O(n) - goal

        dabca
         bcab
          cabc
           abcb
            
        set: a,b,c,
        '''

        chars = set()
        l,r,max_len=0,0,0

        while r<len(s):
            while s[r] in chars:
                chars.remove(s[l])
                l+=1

            chars.add(s[r])
            max_len=max(max_len,r-l+1)
            r+=1  
        
        return max_len