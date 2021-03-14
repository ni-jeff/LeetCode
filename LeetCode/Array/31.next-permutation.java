/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        while(i>0&&nums[i]<=nums[i-1]){i--;}
        int end=nums.length-1;
        for(int j=end;i>0&&j>=i;j--){
            if(nums[j]>nums[i-1]){
                swap(nums,j,i-1);
                break;
            }
        }
        while(end-i>0){
            swap(nums, end, i);
            end--;
            i++;
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
// @lc code=end

/*notes:
    1.要对不同情况找共同方法，合并精简代码
solution：
    1.从后往前根据全排列的方法找到最后固定的一位，调换后对固定位以后的进行反转
*/