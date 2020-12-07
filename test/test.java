import java.util.*;
/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */
// @lc code=start
public class test{
    public static void main(String[] args) {
        Solution solution=new Solution();
        int nums[]={1};
        solution.nextPermutation(nums);
        System.out.println(nums);
    }
}
class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        // if(i<1)return;
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