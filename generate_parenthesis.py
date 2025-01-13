class Generate_Parentheses:
    def generateParenthesis(self, n: int) -> List[str]:
        '''
        BF: n^n

        ()(())
        ((()))
        (()())
        (())()
        ()()()

        (
            ((  ()
            ((( (()
        '''
        ans=[]
        self.helper(n,"",ans,n)
        return ans
    
    def helper(self,openLeft,string,ans,n):
        if openLeft==0:
            if(self.valid(string)):
                ans.append(string)
                return
        
        if(openLeft>0):
            self.helper(openLeft-1,string+"(",ans,n)
        if(len(string)>0 and len(string)<n*2):
            self.helper(openLeft,string+")",ans,n)
    
    def valid(self,string):
        stack=[]

        for i,c in enumerate(string):
            if c=='(':
                stack.append(c)
            else:
                if len(stack)==0:
                    return False
                stack.pop()

        return len(stack)==0