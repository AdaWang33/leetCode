/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */

import java.util.Arrays;

/**
 * 思路：
 * 第一种：暴力解法，直接两个array合并，找出median，但时间复杂度达不到要求
 * 第二种：使用【分治法】！若m+n为奇数，则应该得到第（m+n）/2小的数，若m+n为偶数，则应该得到第（m+n-1）/2小和第（m+n+1）/2小的平均数，下面求第k小的数：
 * 假设是在m<n的情况下，若不是，则交换A，B（A的个数为m，B的个数为n）
 * 1.在A中取k/2，可能不够，因此取pa=min（k/2，m），在B中取pb=k-pa
 * 2.比较A[pa]和B[pb]，枪打出头鸟
 * 若A的小，则说明要求的数在A[pa+1,m]以及B[0,n]之间，找第k-pa小的数，用递归进行计算；
 * 若B的小，则说明要求的数在A[0,m]和B[pb+1,n]之间，找第k-pa小的数，用递归进行计算
 */

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // set down the index to look for, k starting from 1!!!
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1) {
            return (findByIndex(nums1, 0, nums2, 0, (m + n) / 2 + 1));
        } else {
            return ((findByIndex(nums1, 0, nums2, 0, (m + n) / 2) + findByIndex(nums1, 0, nums2, 0, (m + n) / 2 + 1)) / 2.);
        }
    }

    public double findByIndex(int[] A, int startOfA, int[] B, int startOfB, int index) {
        //边界条件here
        if (startOfA == A.length) {
            return B[startOfB + index - 1];
        }
        if (startOfB == B.length) {
            return A[startOfA + index - 1];
        }

        if (index == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }

        //谁小谁有排除一半的权力
        int halfKthOfA = startOfA + index / 2 - 1 < A.length
                ? A[startOfA + index / 2 - 1]
                : Integer.MAX_VALUE;
        int halfKthofB = startOfB + index / 2 - 1 < B.length
                ? B[startOfB + index / 2 - 1]
                : Integer.MAX_VALUE;
        if (halfKthOfA < halfKthofB) {
            return findByIndex(A, startOfA + index / 2, B, startOfB, index - index / 2);
        } else {
            return findByIndex(A, startOfA, B, startOfB + index / 2, index - index / 2);
        }
    }

}

