class Solution {
    public int[] exchange(int[] nums) {
        int len=nums.length;
        int head=0;
        int end=len-1;
        while(head<end){
            while(head<end&&nums[head]%2==1){
                head++;
            }
            while(head<end&&nums[end]%2==0){
                end--;
            }
            swap(nums,head,end);
            head++;
            end--;
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}