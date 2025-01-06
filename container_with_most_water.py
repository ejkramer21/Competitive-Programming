class Container_with_most_water:
    def maxArea(self, height: List[int]) -> int:

        '''
        BF: try all combos - O(n^2)

        opt: greedy assumption: choose biggest min height of the pair possible

        1 8 6 2 5 4 8 3 7
        '''

        l,r=0,len(height)-1
        maxV=0
        while l<r:
            maxV=max(maxV,min(height[l],height[r])*(r-l))
            if height[l]<height[r]:
                l+=1
            else:
                r-=1

        return maxV