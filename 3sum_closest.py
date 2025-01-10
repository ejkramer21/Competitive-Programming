class ThreeSum_Closest:
    def threeSumClosest(self, nums: List[int], target: int) -> int:

        '''
        -4 -1 1 2

        i l     r
        '''

        nums.sort() #nlogn
        ans=2**32-1

        for i in range(len(nums)-2): #n
            l=i+1
            r=len(nums)-1

            while l<r: #logn
                a=nums[i]+nums[l]+nums[r]
                if abs(target-ans)>abs(target-a):
                    ans=a
                if a==target:
                    return target
                elif a<target:
                    l+=1
                else:
                    r-=1

        return ans
        