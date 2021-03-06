import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */
// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=kSum(nums,target,0,4);
        return res;
    }
    public List<List<Integer>> kSum(int[] nums,int ktarget,int start,int k){
        List<List<Integer>> ansList=new ArrayList<>();
        if(nums.length<k||nums[start]*k>ktarget||nums[nums.length-1]*k<ktarget)return ansList;
        if(k==2){
            int left=start;
            int right=nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]==ktarget){
                    List<Integer> ans=new ArrayList<>();
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    ansList.add(ans);
                    while(left<right&&nums[left]==nums[left+1])left++;
                    while(left<right&&nums[right]==nums[right-1])right--;
                    left++;
                    right--;
                }
                else if(nums[left]+nums[right]>ktarget)right--;
                else left++;
            }
            return ansList;
        }
        else{
            for(int i=start;i<nums.length-k+1;i++){
                if(i>start&&nums[i]==nums[i-1])
                    continue;
                List<List<Integer>> temp=kSum(nums,ktarget-nums[i],i+1,k-1);
                    for(List<Integer> t : temp){
                        t.add(0,nums[i]);
                        ansList.add(t);
                    }
            }
        }
        return ansList;
    }
}
// @lc code=end

/*
notes:
    1.当出现2sum、3sum、4sum时就应思考本题考查的是ksum的抽象方法
*/