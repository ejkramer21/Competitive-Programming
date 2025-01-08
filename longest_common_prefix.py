class Longest_common_prefix:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        '''
        Trie: children, char
        root: [Tries](children)
        '''

        root=Trie('0')
        cur=root
        maxLen=2**32-1
        for i,st in enumerate(strs):
            leng=0
            for ind,car in enumerate(st):
                if ind>=maxLen:
                    break
                if not car in cur.childTrie:
                    if i!=0:
                        break
                    cur.childTrie[car]=Trie(car)
                cur=cur.childTrie[car]
                leng+=1
            cur=root
            maxLen=min(leng,maxLen)
        return strs[0][0:maxLen]

class Trie:
    car='0'
    childTrie={}

    def __init__(self,car):
        self.car=car
        self.childTrie={}
        