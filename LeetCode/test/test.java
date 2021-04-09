import java.util.*;
/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */
// @lc code=start
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.findNthDigit(10);
        System.out.println((ans));
    }
}
class Solution {
    public int findNthDigit(int n) {
        if(n==0){
            return 0;
        }
        int count=1;
        int digit=1;
        int flag=1;
        while(n>=count){
            n-=count;
            count=9*digit*flag;
            digit*=10;
            flag++;
        }
        digit/=10;
        flag--;
        int num=n/flag+digit;
        for(int i=0;i<num%flag;i++){
            num/=10;
        }
        return num%10;
    }
}