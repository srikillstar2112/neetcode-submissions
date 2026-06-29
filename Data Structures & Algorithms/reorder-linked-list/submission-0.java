/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        //middle element
        ListNode s=head;ListNode f=head;
        while(f.next!=null && f.next.next!=null){
            s=s.next;f=f.next.next;
        }
        //reversed
        ListNode curr=s.next;
        s.next=null;
        ListNode p=null;
        while(curr!=null){
            ListNode front=curr.next;
            curr.next=p;
            p=curr;
            curr=front;
        }
        //ordering
        ListNode first=head;
        ListNode sec=p;
        while(sec!=null){
            ListNode t1=first.next;
            ListNode t2=sec.next;
            first.next=sec;
            sec.next=t1;
            first=t1;
            sec=t2;
        }
        System.out.println(head);
    }
}
