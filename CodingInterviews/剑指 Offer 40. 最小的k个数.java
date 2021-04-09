// solution1: quicksort
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null||k==0){
            return new int[0];
        }
        quickSort(arr,0,arr.length-1,k);
        return Arrays.copyOf(arr,k);

    }
    public void quickSort(int[] nums, int low, int high,int k) {
        int i = low;
        int j = high;
        if (i > j) {
            return;
        }
        int flag = nums[low];
        while (i < j) {
            while (nums[j] >= flag && i < j) {
                j--;
            }
            while (nums[i] <= flag && i < j) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, low);
        if(j==k){
            return;
        }
        else if(j>k){
            quickSort(nums, low, j-1, k);
        }
        else{
        quickSort(nums, j+1, high, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// solution2 : heap
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null||k==0){
            return new int[0];
        }
        Queue<Integer> heap=new PriorityQueue<>((i1,i2)->(i2-i1));
        for(int num:arr){
            if(heap.size()<k){
                heap.offer(num);
            }
            else if(num<heap.peek()){
                heap.poll();
                heap.offer(num);
            }
        }
        int [] res=new int[k];
        int i=0;
        for(int num:heap){
            res[i]=num;
            i++;
        }
        return res;
    }
}