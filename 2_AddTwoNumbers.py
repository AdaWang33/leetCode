You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.



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
