Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        """
        【思路】：
        1.两个循环：外层从第一个元素循环到最后一个，里层从第二个开始，找最长substring，finished却不能submit，但感觉应该是对的
        """

        l = len(s)
        a = ["" for x in range(l)]
        for i in range(l):
            if i<l-1:
                for j in range(1,l):
                    if  s[j] not in a[i]:
                        a[i] += s[j]
                    else:
                        break
        b = max(a, key=len)
        return len(b)
        
        """
        record_tuple = [(v, i) for i, v in enumerate(s)]

        record, i, count, longest = {}, 0, 0, 0
        while i < len(s):
            current = s[i]

            if current not in record:
                count += 1
                record[current] = i
            else:
                longest = max(count, longest)
                count = i - record[current]
                record = dict(record_tuple[record[current] + 1 : i + 1])
            i += 1

        return max(count, longest)
        """
        

        
                    
            
                
