//382. Linked List Random Node

#python3
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def __init__(self, head: Optional[ListNode]):
        self.head = head

    def getRandom(self) -> int:
        count = 0
        result = None
        current = self.head
        while current:
            count += 1
            # select currrent node with probability 1/count
            if random.randint(1, count) == 1:
                result = current.val
            current = current.next
        return result


# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()


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

import java.util.Random;
 
class Solution {
    List<Integer> list;
    ListNode head;
    public Solution(ListNode head) {
        //put all data from LL to list
        ListNode start = head;
        list = new ArrayList<>();
        while (start != null){
            list.add(start.val);
            start = start.next;
        }
    }
    
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */