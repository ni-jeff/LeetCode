/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode res=head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }
            else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        head.next = l1 != null ? l1 : l2;
        return res.next;
    }
}

// solution: 哑指针