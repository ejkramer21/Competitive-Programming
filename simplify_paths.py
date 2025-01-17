class SimplifyPaths:
    def simplifyPath(self, path: str) -> str:
        '''
        stack + string:

        home, foo

        /home/foo

        home/ user/ pictures
        '''

        dirs = path.split("/")
        print(dirs)
        stack=[]
        for dir in dirs:
            if not dir:
                continue
            if dir=="." or (dir==".." and not stack):
                continue
            elif dir=="..":
                stack.pop()
            else:
                stack.append(dir)


        ans="/"

        for i,dir in enumerate(stack):
            ans+=dir
            if(i!=(len(stack)-1)):
                ans+="/"

        return ans