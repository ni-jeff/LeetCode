/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end

/*
Notes
	1. 使用map可以快速地在数组中查找某一个值
	2. 由于只有一个解，所以往map中置入数据时，就可以开始往前查找是否有解

Solutions
	1. 暴力
	2. hashmap匹配
    3.边hashmap边往前查找
*/