class zigzag_conversion:
    def convert(self, s: str, numRows: int) -> str:

        '''
        PAYPALISHIRING
        len(s)=14
        14//3=4 -> +4 = 8 -> num cols
        
        P   A   H
        A P L S
        Y   I

        fill out a 2D char Array
        '''
        if numRows==1:
            return s
        r,c=0,0
        arr = [['' for _ in range((len(s)//numRows)  *2+1)] for _ in range(numRows)]
        dir=1 #1= down, 0=up

        for car in s:
            arr[r][c]=car

            if dir==1:
                r+=1
            else:
                r-=1
            
            if r<=-1 and dir==0:
                dir=1
                c+=1
                r+=2

            elif r>=numRows and dir==1:
                dir=0
                c+=1
                r-=2

        return ''.join(''.join(row) for row in arr)
        