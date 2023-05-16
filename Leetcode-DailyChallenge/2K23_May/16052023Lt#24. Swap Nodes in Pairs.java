//24. Swap Nodes in Pairs

#python3
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur and cur.next:
            left = cur
            right = cur.next
            cur = cur.next.next
            left.val, right.val = right.val, left.val
        
        return head

//Java
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode d = new ListNode(0), a;
        d.next = head;
        a = d;

        while (head != null && head.next != null){
            a.next = head.next;
            head.next =  a.next.next;
            a.next.next = head;

            head = head.next;
            a = a.next.next;
        }

        return d.next;
    }
}