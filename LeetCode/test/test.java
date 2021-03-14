import java.util.*;
/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */
// @lc code=start
public class test{
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] nums={{1,1}};
        boolean ans=solution.findNumberIn2DArray(nums,0);
        System.out.println(ans);
    }
}class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int col=matrix[0].length-1;
        int row=0;
        while(col>=0&&row<matrix.length){
            if(matrix[col][row]==target){
                return true;
            }
            else if(matrix[col][row]>target){
                col--;
            }
            else if(matrix[col][row]<target){
                row++;
            }
        }
        return false;
    }
}