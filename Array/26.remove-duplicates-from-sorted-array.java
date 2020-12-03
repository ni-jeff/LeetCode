/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int flag=0;
        for(int i=1;i<nums.length;i++){
            if(nums[flag]<nums[i]){
                nums[flag+1]=nums[i];
                flag++;
            }
        }
        return flag+1;
    }
}
// @lc code=end

/*
Notes
	1. 返回值不需返回数组，因为传入参数是引用

Solutions
    1.双指针
*/