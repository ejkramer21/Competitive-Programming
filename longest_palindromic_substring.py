class longest_palindromic_substring:
    def longestPalindrome(self, s: str) -> str:
        '''
        BF: get all possible substrings n! substrings n!*n
        sliding window? 2 ptr

        babad
        
          i
        l
            r
        '''

        max_pal=""
        max_len=0
        for i in range(0,len(s)-1):
            l=i
            r=i

            while r<len(s) and s[r]==s[i]:
                
                if max_len<r-l+1:
                    max_len=r-l+1
                    max_pal=s[l:r+1]
                r+=1

            l-=1
            while l>=0 and r<len(s) and s[l]==s[r]:
                
                if max_len<r-l+1:
                    max_len=r-l+1
                    max_pal=s[l:r+1]
                l-=1
                r+=1

        return s[0] if max_len==0 else max_pal