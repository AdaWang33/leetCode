/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Math.min(height[left], height[right])*(right-left);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            area = Math.max(area, Math.min(height[left], height[right])*(right-left));;
        }
        return area;

    }
}


/**
 * 暴力解法
 * double max = -1;
 * for (int i = 0; i < height.length - 1; i++) {
 * for (int j = i + 1; j < height.length; j++) {
 * max = Math.max(max, calArea(height[i], i, height[j], j));
 * }
 * }
 * if(max<0)return 0;
 * return (int)max;
 * }
 * <p>
 * private double calArea(int a, int ia, int b, int ib) {
 * double area = -1;
 * area = (Math.min(a, b)) * (ib - ia) ;
 * return area;
 */



