/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList=new ArrayList<>();

        if(nums.length<3)return ansList;

        Arrays.sort(nums);

        if(nums[0]>0)return ansList;

        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])continue;

            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> ans=new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    ansList.add(ans);
                    
                    while(left<right&&nums[left]==nums[left+1])left++;
                    while(left<right&&nums[right]==nums[right-1])right--;
                    left++;
                    right--;
                }
                else if(sum>0)right--;
                else left++;
            }
            
        }
        return ansList;
    }
}
// @lc code=end

// Solutions
// 分治：取一个数，剩余的问题即为2sum（2sum要求对数组排序），再进行双指针