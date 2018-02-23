class Solution(object):
    def twoSum(self, nums, target):
        import numpy as np
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        """
        l = len(nums)
        # 用列表生成器来做，非常省力
        return [[x, y] for x in xrange(l) for y in xrange(x,l) if nums[x] + nums[y] == target and x != y][0]
        

        # 知道错在哪里了，返回的是值而不是序号，但答案依然没看懂
        l = len(nums)
        a = [[nums[x],(target-nums[x])] for x in range(l) if (target-nums[x]) in nums and (target-nums[x]) != nums[x]][0]
        return a
        """

        

        # 此为答案
        d={}
        for i,num in enumerate(nums):
            if target-num in d:
                return d[target-num], i
            d[num]=i
    
        
        
        
        
        
                
        
