# 934. Shortest Bridge

# python3
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        # using fast and slow pointer getting the middle element 
        # then the elements after middle is not changed but the elements before middle change the direction like ex: 1->2->3->4->null then 3 is at slow pointer middle, then final one null<-1<-2 | 3->4->null
        # then iterate through both of these and then compare the sum of two linked lists
        slow, fast = head, head
        prev = None
        while fast and fast.next:
            fast = fast.next.next

            tmp = slow.next # store this link as we are going to change this slow.next to previous one - preserve this
            slow.next = prev # changing the direction
            prev = slow # moving prev
            slow = tmp # stored temp - moving slow to next
        
        res = 0

        while slow:
            res = max(res, prev.val + slow.val)
            prev = prev.next
            slow = slow.next
        
        return res