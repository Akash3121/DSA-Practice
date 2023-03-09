//142. Linked List Cycle II

//Java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Logic:slow and fast pointer

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                //found a cycle
                //now we nened to loop as fast it the end cycle, start assiging to 0 and loop where slow and fast not equal then both meets at the cycle(return value)
                slow = head;
                while (slow != fast){
                    slow= slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}