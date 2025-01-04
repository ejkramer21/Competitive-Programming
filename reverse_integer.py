class reverse_integer:
    def reverse(self, x: int) -> int:
        '''
        123%10 = 3
        sum=3
        123//10=12
        12%10=2
        12//10=1
        sum*10+2=32
        1%10=1
        1//10=0
        sum*10+1=321
        break
        '''

        sum=0
        neg=x<0
        x=abs(x)
        while x != 0:
            sum=sum*10+x%10
            x//=10

        if sum>2**31-1:
            return 0
        return sum if not neg else -sum