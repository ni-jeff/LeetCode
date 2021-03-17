/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            return head.next;
        }
        ListNode start=head;
        ListNode node=head;
        while(node!=null){
            if(node.val==val){
                node=node.next;
                head.next=node;
                break;
            }
            head=node;
            node=node.next;
        }
        return start;
    }
}