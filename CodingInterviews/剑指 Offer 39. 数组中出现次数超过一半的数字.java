// solution1 : hashmap + count>length/2
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > (nums.length) / 2) {
                return i;
            }
        }
        return nums[0];
    }
}
// solution 1 :(in complex code)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                int count=map.get(i)+1;
                if(count>(nums.length)/2){
                    return i;
                }
                else{
                    map.put(i,count);
                }
            }
            else map.put(i,1);
        }
        return nums[0];
    }
}
// solution 2 : vote
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
