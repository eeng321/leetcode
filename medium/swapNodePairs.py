# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        #swap first two
        if head and head.next:
            next_next = head.next.next
            new_head = head.next
            new_head.next = head
            head.next = next_next
        else:
            return head     #return if less than 2 nodes
        
        prev = head
        curr = head.next
        #swap
        while curr and curr.next:
            next_next = curr.next.next
            prev.next = curr.next
            swap = curr.next
            swap.next = curr
            prev.next = swap
            curr.next = next_next
            prev = curr
            curr = next_next
            
        return new_head
        