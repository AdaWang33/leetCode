class Solution(object):
    def twoSum(self, nums, target):
        import numpy as np
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        import numpy as np
        l = len(nums)
        # 用列表生成器来做，非常省力
        return [[x, y] for x in xrange(l) for y in xrange(x,l) if nums[x] + nums[y] == target and x != y][0]
        
