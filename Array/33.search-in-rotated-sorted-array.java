/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=(right-left)/2+left;
        while(left<right){
            if(nums[mid]<nums[right]){
                if(target<=nums[right]&&target>=nums[left]){
                    
                }
            }
        }
    }
}
// @lc code=end

