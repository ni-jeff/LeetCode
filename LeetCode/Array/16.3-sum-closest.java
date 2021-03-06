/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int result=nums[i]+nums[left]+nums[right];
                if(Math.abs(result-target)<Math.abs(ans-target))ans=result;
                if(result==target)return target;
                else if(result>target)right--;
                else left++;
            }
        }
        return ans;
    }
}
// @lc code=end

/*
Notes
	1. Math.abs()方法在int的最小边界时会出现绝对值为负值的情况

Solutions
同3sum类似，用两头逼近的方法，遍历所有解
*/