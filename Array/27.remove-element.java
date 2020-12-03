/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int j=nums.length;
        int i=0;
        while(i<j){
            if(nums[i]==val){
                nums[i]=nums[j-1];
                j--;
            }
            else
                i++;
        }
        return i;
    }
}
// @lc code=end

