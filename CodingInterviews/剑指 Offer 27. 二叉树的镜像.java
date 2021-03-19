/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// solution1: recursion
class Solution {
    TreeNode temp=null;
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))return root;

        temp=root.left;
        root.left=root.right;
        root.right=temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
// solution2: stack
// cant save much space
class Solution {
    TreeNode temp;
    TreeNode node;
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)return root;
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            node=stack.pop();
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}