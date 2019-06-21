# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if m == n:
            return head
        
        new_node = ListNode(0)
        new_node.next = head
        pre = new_node
        
        for i in range(m-1):
            pre = pre.next
        
        curr = pre.next
        reverse = None
        
        for i in range(n - m + 1):
            third = curr.next
            curr.next = reverse
            reverse = curr
            curr = third
        
        pre.next.next = curr
        pre.next = reverse
        
        return new_node.next