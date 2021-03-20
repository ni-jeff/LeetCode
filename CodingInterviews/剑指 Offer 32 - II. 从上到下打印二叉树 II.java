/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList=new ArrayList<>();
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        if(root!=null)nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){
            List<Integer> tempList=new ArrayList<>();

            for(int i=nodeQueue.size();i>0;i--){
                TreeNode node=nodeQueue.poll();
                tempList.add(node.val);

                if(node.left!=null)nodeQueue.add(node.left);
                if(node.right!=null)nodeQueue.add(node.right);
            }

            ansList.add(tempList);
        }
        return ansList;
    }
}