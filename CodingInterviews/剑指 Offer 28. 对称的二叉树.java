/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// solution1 recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
// solution2 queue
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode leftTree=queue.remove();
            TreeNode rightTree=queue.remove();

            if(leftTree==null&&rightTree==null){
                continue;
            }

            if(leftTree==null||rightTree==null||leftTree.val!=rightTree.val){
                return false;
            }

            queue.add(leftTree.left);
            queue.add(rightTree.right);
            queue.add(leftTree.right);
            queue.add(rightTree.left);
        }
        return true;
    }
}