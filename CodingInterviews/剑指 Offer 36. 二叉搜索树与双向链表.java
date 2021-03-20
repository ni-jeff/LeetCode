/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node prev,head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        prev.right=head;
        head.left=prev;
        return head;
    }
    public void dfs(Node curr){
        if(curr==null){
            return;
        }
        dfs(curr.left);
        if(prev!=null)prev.right=curr;
        else head=curr;
        curr.left=prev;
        prev=curr;
        dfs(curr.right);
    }
}