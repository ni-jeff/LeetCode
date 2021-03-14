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
        int nums[]={2,3,2,2,7};
        List<List<Integer>> list=new ArrayList<>();
        list=solution.combinationSum(nums,7);
        System.out.println(nums);
    }
}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(candidates);
        backtrace(ans, new ArrayList<Integer>(), candidates, target, 0);

        return ans;
    }

    private void backtrace(List<List<Integer>> List,List<Integer> tempList,int[] nums,int target,int start){
        if(target<0){
            return;
        }

        else if(target==0){
            List.add(new ArrayList<>(tempList));
        }

        else if(target>0){

            for(int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                backtrace(List, tempList, nums, target-nums[i], start);
                tempList.remove(tempList.size()-1);
            }

        }
    }
}

// @lc code=end