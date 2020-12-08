/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]={-1,-1};
        if(nums.length==0||nums[0]>target||nums[nums.length-1]<target)return ans;
        int left=search(nums,target,true);
        if(nums[left]!=target)return ans;
        ans[0]=left;
        ans[1]=search(nums,target,false)-1;
        return ans;
    }
    public int search(int[] nums,int target, boolean isleft){
        int left=0;
        int right=nums.length;
        while(left<right){
            int mid=(right+left)/2;
            if((nums[mid]==target&&isleft)||nums[mid]>target)right=mid;
            else left=mid+1;
        }
        return left;
    }
}
// @lc code=end

