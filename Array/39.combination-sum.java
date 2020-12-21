import java.util.*;
/*
* @lc app=leetcode id=39 lang=java
*
* [39] Combination Sum
*/

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(ans, new ArrayList<Integer>(), candidates, target, 0);

        return ans;
    }

    private void backtrack(List<List<Integer>> List,List<Integer> tempList,int[] nums,int target,int start){
        if(target<0){
            return;
        }

        else if(target==0){
            List.add(new ArrayList<>(tempList));
        }

        else if(target>0){

            for(int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                backtrack(List, tempList, nums, target-nums[i], i);
                tempList.remove(tempList.size()-1);
            }

        }
    }
}
// @lc code=end
/* solution:
    1.backtrack:回溯要记住的点在于找到求解方法中哪个过程的重复的，找到边界点和全局变量;
    ***************************************************************************
            class Solution {
                public List<List<Integer>> combinationSum(int[] candidates, int target) {
                    List<List<Integer>> ans=new ArrayList<>();
                    Arrays.sort(candidates);

                    backtrack(ans, new ArrayList<Integer>(), candidates, target, 0);

                    return ans;
                }

                private void backtrack(List<List<Integer>> List,List<Integer> tempList,int[] nums,int target,int start){
                    if(target<0){
                        return;
                    }

                    else if(target==0){
                        List.add(new ArrayList<>(tempList));
                    }

                    else if(target>0){

                        for(int i=start;i<nums.length;i++){
                            tempList.add(nums[i]);
                            backtrack(List, tempList, nums, target-nums[i], i);
                            tempList.remove(tempList.size()-1);
                        }

                    }
                }
            }
    ****************************************************************************
    2.
*/