/*
// Definition for a Node.
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
*/
// solution 1 : 原地复制链表+复制random关系+拆分和复原原链表
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node curr=head;
        while(curr!=null){
            Node temp= new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            curr=temp.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        curr=head.next;
        Node origin=head, ans=curr;
        while(curr.next!=null){
            origin.next=origin.next.next;
            curr.next=curr.next.next;
            origin=origin.next;
            curr=curr.next;
        }
        origin.next=null;
        return ans;
    }
}
// solution 2: map->原节点和新节点关系 + map.get()复制next & random 关系
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node curr=head;
        Map<Node,Node> map=new HashMap<>();
        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            map.get(curr).next=map.get(curr.next);
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }
        return map.get(head);
    }
}