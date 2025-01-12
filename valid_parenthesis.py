class ValidParens:
    def isValid(self, s: str) -> bool:
        stack=[]

        for i,c in enumerate(s):
            if c=='(' or c=='{' or c=='[':
                stack.append(c)
            elif len(stack)==0:
                return False
            elif c==')':
                rem = stack.pop()
                if rem!='(':
                    return False
            elif c=='}':
                rem = stack.pop()
                if rem!='{':
                    return False
            else:
                rem = stack.pop()
                if rem!='[':
                    return False
        return len(stack)==0