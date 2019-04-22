# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0 # important in making it fast, global carry variable
        temp1 = l1
        temp2 = l2
        tempSum = temp1.val + temp2.val
        outList = ListNode(tempSum % 10)
        currNode = outList
        
        if(tempSum > 9):
            carry = 1
        else: 
            carry = 0
        
        temp1 = temp1.next
        temp2 = temp2.next
        
        if(temp1 == None and temp2 == None):
            if(carry == 1):
                currNode.next = ListNode(1)
        else:
            while(temp1 != None or temp2 != None):
                
                # l1 bigger than l2
                if(temp1 != None and temp2 == None):
                    while(temp1 != None):
                        tempSum = temp1.val + carry
                        currNode.next = ListNode(tempSum % 10)
                        if(tempSum > 9):
                            carry = 1
                        else:
                            carry = 0
                            
                        temp1 = temp1.next
                        currNode = currNode.next
                    
                        
                # l2 bigger than l1
                elif(temp1 == None and temp2 != None):
                    while(temp2 != None):
                        tempSum = temp2.val + carry
                        currNode.next = ListNode(tempSum % 10)
                        if(tempSum > 9):
                            carry = 1
                        else:
                            carry = 0
                            
                        temp2 = temp2.next
                        currNode = currNode.next
                
                # l1 and l2 are same size
                else:
                    while(temp1 != None and temp2 != None):
                        tempSum = temp1.val + temp2.val + carry
                        currNode.next = ListNode(tempSum % 10)
                        if(tempSum > 9):
                            carry = 1
                        else:
                            carry = 0
                        
                        temp1 = temp1.next
                        temp2 = temp2.next
                        currNode = currNode.next
                        
                # last node is a carry over
                if(temp1 == None and temp2 == None):
                    if(carry == 1):
                        currNode.next = ListNode(1)
            
        return outList
                    