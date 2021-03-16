class Solution {
    public int minArray(int[] numbers) {
        if(numbers.length==0){
            return -1;
        }
        int start=0;
        int end=numbers.length-1;
        int mid=(end+start)/2;
        while(start<end){
            mid=(end+start)/2;
            if(numbers[mid]<numbers[end]){
                end=mid;
            }
            else if(numbers[mid]>numbers[end]){
                start=mid+1;
            }
            else if(numbers[mid]==numbers[end]){
                // if(numbers[mid]<numbers[start]){
                //     end=mid;
                // }
                // else if(numbers[mid]>numbers[end]){
                //     start=mid+1;
                // }
                // else if(numbers[mid]==numbers[end]){
                //     end=MidInOrder(numbers,start,end);
                //     break;
                // }
            }
        }
        return numbers[end];
    }
    // public int MidInOrder(int[] numbers,int start,int end){
    //     while(start<end){
    //         if(numbers[end-1]>numbers[end]){
    //             return end;
    //         }
    //         end--;
    //     }
    //     return end;
    // }
}

// notes: 当出现中间值与前后末端值相同时，可以将后端值向前移。因存在相同值，故不会丢失数据。