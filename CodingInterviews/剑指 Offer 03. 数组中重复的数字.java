class Solution {
    public int findRepeatNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]==i){
                i++;
                continue;
            }
            else{
                if(nums[nums[i]]==nums[i]){
                    return nums[i];
                }
                else{
                    int temp=nums[nums[i]];
                    nums[nums[i]]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        return -1;
    }
}