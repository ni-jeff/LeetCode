/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution1：新建栈法
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode node=head;
        while(node!=null){
            stack.push(node);
            node=node.next;
        }
        int count=stack.size();
        int[] arr=new int[count];
        for(int i=0;i<count;i++){
            arr[i]=stack.pop().val;
        }
        return arr;
    }
}

// Solution2：反转链表法
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode next=head;
        ListNode curr=head;
        ListNode prev=null;
        int count=0;
        while(next!=null){
            count++;
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        int[] arr=new int[count];
        for(int i=0;i<count;i++){
            arr[i]=head.val;
            head=head.next;
        }
        return arr;
    }
}