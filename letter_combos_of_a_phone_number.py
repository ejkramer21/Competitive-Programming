class LetterCombosOfPhoneNumber:
    def letterCombinations(self, digits: str) -> List[str]:
        mappings={
            '2':'abc',
            '3':'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
           '9': 'wxyz'
        }

        combos=[]

        self.helper(combos,0,digits,"",mappings) #n2^n

        return combos

    def helper(self,combos,ind,digits,sofar,mappings): #n
        if ind==len(digits):
            if len(sofar)==0:
                return
            combos.append(sofar)
            return

        for letter in mappings[digits[ind]]: #4^n aka 2^b
            cop = copy.copy(sofar)
            cop+=letter
            self.helper(combos,ind+1,digits,cop,mappings)


    