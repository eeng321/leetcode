# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        def getLength(list):
            nth = 0
            while(list != None):
                list = list.next
                nth += 1
            return nth

        nth = getLength(head) - n #number of times to traverse linked list
        print(nth)
        
        #linked list only has 1 node
        if(head.next == None):
            return None
        elif(nth == 0): #remove first node
            return head.next
        elif(n == 1 and (head.next).next == None): #remove last node when only 2 nodes
            head.next = None
            return head
        
        i = 0
        node = head
        #for all situations with 3 or more nodes
        while i < nth - 1: #stop at the node before the node getting deleted
            node = node.next
            i += 1
        node.next = (node.next).next
        return head
        