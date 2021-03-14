import java.util.ArrayList;
import java.lang.annotation.Target;
import java.util.*;
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, ansList, new ArrayList<Integer>(), target, 0);
        return ansList;
    }

    public void backtrack(int[] nums, List<List<Integer>> List, List<Integer> tempList, int target, int start) {
        if (target == 0) {
            List.add(new ArrayList<>(tempList));
        } 
        else if (target < 0) {
            return;
        } 
        else if (target > 0) {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {//remove repetive first-num
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(nums, List, tempList, target - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
// @lc code=end
// solution:1.backtrack
// notes:1.sometimes, when you try to shorten to time usage by using some if sentence, it causes more time.