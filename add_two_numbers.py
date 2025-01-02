# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional,ListNode
class addTwoNumbers:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:

        '''
        i=0
        sum1=0, 2*0 + 0->2, 4*10+2=42, 3*100 + 42 = 342
        sum2 = 465

        --> 807

        807%10 =7
        807/=10 -> 80

        ListNode root = empty
        root next = ListNode(7)

        return root.next

        '''

        sum1,sum2=0,0
        tens=1

        while l1 or l2:
            if l1!= None:
                sum1 = l1.val*tens + sum1
                l1=l1.next
            if l2!= None:
                sum2 = l2.val*tens + sum2
                l2=l2.next
            tens*=10

        su=sum1+sum2
        root=ListNode()
        node=root

        if su==0:
            return ListNode(0)
        while su!=0:
            node.next=ListNode(su%10)
            su//=10
            node=node.next

        return root.next
        