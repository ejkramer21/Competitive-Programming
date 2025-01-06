class palindrome_number:
    def isPalindrome(self, x: int) -> bool:

        '''
        123

        123%10 = 3
        123//100=1
        -> break

        121
        121%10=1
        121//100=1
        121-(121//100)*100 = 21
        21/=10 -> 2

        242
        242%10=2
        242//100=2
        242-(242//100)*100 = 242-200=42
        42//10 = 4

        1221
        1221%10=1
        1221//1000=1
        1221-(1*1000)=221
        221//10 = 22
        22%10=2
        22//10=2
        22-2*10=2
        2//10=0-> break

        '''
        if x<0:
            return False
        if x==0:
            return True
        num_tens = math.floor(math.log10(x))
        num_tens=10**num_tens

        while x!=0:
            
            ones=x%10
            tens=x//num_tens

            if ones!=tens:
                
                return False

            x-=(tens*num_tens)
            x//=10

            num_tens/=100

        return x==0
        