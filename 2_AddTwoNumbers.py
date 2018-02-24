# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

"""
【思路】：
1.逐位相加，注意进位问题

【知识点】：
1.linked list
2.最后return是从header开始，让list node的更新清晰简单
"""
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        quotient = 0
        ans = l3 = ListNode(0)
        
        while l1 or l2 or quotient:
            a = b = 0
            if l1 != None:
                a = l1.val
                l1 = l1.next
            if l2 != None:
                b = l2.val
                l2 = l2.next
            quotient,remainder = divmod(a+b+quotient,10)
            l3.next = ListNode(remainder)
            l3 = l3.next
            
        return ans.next
