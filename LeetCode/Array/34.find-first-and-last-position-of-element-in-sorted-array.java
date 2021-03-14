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

/* note:
    1.求中位数不是每次都要用差值再加，要考虑数值范围是否需要；
    2.要理解二分法的终点在哪，左右边界值及判断条件会带来什么影响

    solution:
    1.二分查找找到一个target后向前后遍历，o(logn+n)
    2.二分查找前后边界值
*/