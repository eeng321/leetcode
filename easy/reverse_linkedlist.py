# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        elif head.next.next == None:
            new_head = head.next
            new_head.next = head
            head.next = None
            return new_head
        else:
            prev, curr, nex = head, head.next, head.next.next
            prev.next = None
            while nex != None:
                curr.next = prev
                prev = curr
                curr = nex
                nex = nex.next
            curr.next = prev
            return curr
                