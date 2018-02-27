class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        """
        思路：
        第一种：暴力解法，直接两个array合并，找出median，但时间复杂度达不到要求
        第二种：使用【二分法】！若m+n为奇数，则应该得到第（m+n）/2小的数，若m+n为偶数，则应该得到第（m+n-1）/2小和第（m+n+1）/2小的平均数，下面求第k小的数：
        假设是在m<n的情况下，若不是，则交换A，B（A的个数为m，B的个数为n）
        1.在A中取k/2，可能不够，因此取pa=min（k/2，m），在B中取pb=k-pa
        2.比较A[pa]和B[pb]，枪打出头鸟
        若A的小，则说明要求的数在A[pa+1,m]以及B[0,n]之间，找第k-pa小的数，用递归进行计算；
        若B的小，则说明要求的数在A[0,m]和B[pb+1,n]之间，找第k-pa小的数，用递归进行计算
        """

        A = nums1
        B = nums2
        # 首先判断奇偶
        if (len(A)+len(B))%2 == 1:
            k = (len(A)+len(B)+1)/2
            return self.findK(A,B,len(A),len(B),k)
        else:
            k1 = (len(A)+len(B))/2
            k2 = k1 + 1
            return (self.findK(A,B,len(A),len(B),k1)+self.findK(A,B,len(A),len(B),k2))*0.5
            
    # 实现找到第k小的数的算法
    def findK(self,X,Y,m,n,k):
        # 定好顺序，短的在前
        if m > n:
                return self.findK(Y,X,n,m,k)
        # 两个边界条件
        if m == 0:
                return Y[k-1]
        if k == 1:
                return min(X[0],Y[0])
                    
        # 开始二分法
        pa = min(m,k / 2)
        pb = k - pa;
        if X[pa - 1] < Y[pb - 1]:
                return self.findK(X[pa:], Y, m - pa, pb, pb)
        elif X[pa - 1] > Y[pb - 1]:
                return self.findK(X, Y[pb:], pa, n - pb, pa)
        else:
                return X[pa - 1]

        
        

