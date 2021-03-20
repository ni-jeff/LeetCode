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
        int[] nums = { 4,6,7,5};
        System.out.println(solution.verifyPostorder(nums));
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        List<Node> randomArr=new LinkedList<>();
        Node ans=new Node(head.val);
        Node ansHead=ans;
        randomArr.add(head.random);
        while(head.next!=null){
            head=head.next;
            randomArr.add(head.random);
            ans.next=head;
            ans=ans.next;
        }
        ans=ansHead;
        for(int i=0;i<randomArr.size();i++){
            ans.random=randomArr.get(i);
        }
        return ansHead;
    }
}