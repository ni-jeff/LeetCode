/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int water=0;
        while(left<right){
            water=Math.max(water,(right-left)*Math.min(height[right],height[left]));
            if(height[left]<=height[right])
                left++;
            else
                right--;
        }
        return water;
    }
}
// @lc code=end

