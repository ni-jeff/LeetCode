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
            if(nums[mid]==target)return mid;
            if(nums[mid]<nums[right]){
                if(target<=nums[right]&&target>=nums[mid])left=mid+1;
                else right=mid-1;
            }
            else{
                if(target<=nums[mid]&&target>=nums[left])right=mid-1;
                else left=mid+1;
            }
            mid=(right-left)/2+left;
        }
        return nums[mid]==target?mid:-1;
    }
}
// @lc code=end

