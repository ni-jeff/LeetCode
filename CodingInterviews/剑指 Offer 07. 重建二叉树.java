/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursion
class Solution {
    private Map<Integer,Integer> indexMap;
    public TreeNode buildSubTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){
        if (preorderLeft > preorderRight) {
            return null;
        }
        int inorderRoot=indexMap.get(preorder[preorderLeft]);
        TreeNode root=new TreeNode(preorder[preorderLeft]);
        root.left=buildSubTree(preorder, inorder, preorderLeft+1, preorderLeft+inorderRoot-inorderLeft, inorderLeft, inorderRoot-1);
        root.right=buildSubTree(preorder, inorder, preorderLeft+inorderRoot-inorderLeft+1, preorderRight, inorderRoot+1, inorderRight);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return buildSubTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
}

//Solution2: 迭代