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
    private ListNode getkth(ListNode temp, int k){
        while(temp!=null && k>1){
            temp=temp.next;
            k--;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prevGroup=dummy;
        while(true){
            ListNode kth = getkth(prevGroup.next, k);
            if (kth == null)
                break;
            ListNode nextGroup = kth.next;
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;
            while (curr != nextGroup) {
                ListNode front = curr.next;
                curr.next = prev;
                prev = curr;
                curr = front;
            }
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
        return dummy.next;
    }
}
