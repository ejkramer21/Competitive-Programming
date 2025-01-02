from typing import List
class twoSum:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans=[]
        dic = {}
        for i,num in enumerate(nums):
            comp = target-num
            if comp in dic:
                ans.append(dic[comp])
                ans.append(i)
                return ans
            dic[num]=i
        return ans
        

        
        
        