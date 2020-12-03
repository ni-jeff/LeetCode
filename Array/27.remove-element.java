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

/*
Notes
	1.  two pointers 循环时考虑是否可以合并循环
	2. pointer必须标注在想要标注的位置

Solutions
    1.Two pointers from head and end

*/