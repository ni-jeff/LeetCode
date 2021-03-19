/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode kNode=head;
        for(int i=0;i<k;i++){
            if(head.next==null){
                return kNode;
            }
            head=head.next;
        }
        while(head!=null){
            head=head.next;
            kNode=kNode.next;
        }
        return kNode;
    }
}