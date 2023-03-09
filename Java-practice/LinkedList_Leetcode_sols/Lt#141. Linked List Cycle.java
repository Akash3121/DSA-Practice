//141. Linked List Cycle

#python3
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # method 1: take a hashset and store the object, while traversing if we faced any object already present in hashset then it is a cycle. {NOTE: in hashset store the object not the value as value may be duplicate} {TC: O(N) SC:O(N)hashset}

        #Method 2: (implemented) Floyd's Tortoise and hare problem -slow and fast pointer {TC: O(N) SC:O(N)}
        # slow pointer goes one time then fast pointer goes twice as fast as slow pointer -> if both met then it's a cycle

        slow, fast = head, head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        
        return False

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
    public boolean hasCycle(ListNode head) {
        // slow & fast pointer
        if (head == null){
            return false;
        }
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        
        return false;
    }
}
