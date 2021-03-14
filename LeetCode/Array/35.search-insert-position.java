/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int high=nums.length-1;
        int low=0;
        int mid=(high-low)/2+low;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target)high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}
// @lc code=end

/*
Notes
	1. 算中位数时可以通过mid=(high-low)/2+low来避免内存溢出

Solutions
    1.二分法+分情况返回值
*/