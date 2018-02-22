class Solution(object):
    def twoSum(self, nums, target):
        import numpy as np
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        l = len(nums)
        # 用列表生成器来做，非常省力
        return [[x, y] for x in xrange(l) for y in xrange(x,l) if nums[x] + nums[y] == target and x != y][0]
        
        """
        # 不知道问题在哪里总之错了，另外下面的答案也没看懂
        l = len(nums)
        a = [[x,(target-x)] for x in xrange(l) if (target-x) in nums][0]
        return a
        """
        
        """
        # 此为答案
        d={}
        for i,num in enumerate(nums):
            if target-num in d:
                return d[target-num], i
            d[num]=i
        """
        
        
        
        
        
        
