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
        int[][] nums = { {1}, {2}, {3} };
        System.out.println(solution.spiralOrder(nums));
    }
}class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return (new int[0]);
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[] res=new int[cols*rows];
        int i=0;
        int round=0;
        while(i<res.length){
            for(int j=round;j<cols-round;j++){
                if(i==res.length)return res;
                res[i]=matrix[round][j];
                i++;
            }
            for(int j=round+1;j<rows-round;j++){
                res[i]=matrix[j][cols-1-round];
                i++;
            }
            for(int j=cols-1-round-1;j>=round;j--){
                if(i==res.length)return res;
                res[i]=matrix[rows-1-round][j];
                i++;
            }
            for(int j=rows-1-round-1;j>round;j--){
                res[i]=matrix[j][round];
                i++;
            }
            round++;
        }
        return res;
    }
}