# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class RemoveNthNode:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        '''
        1 2 3 4 5
            3  2  1
        '''

        count = self.helper(head,n,False,None,head)
        if n==(count-1):
            return head.next
        return head

    def helper(self,node,n,endfound,prev,head):
        if node==None:
            if 1==n:
                prev.next=None
            return 1
        count = self.helper(node.next,n,endfound,node,head)

        if count==n:
            if prev==None:
                return count+1
            prev.next=node.next

        return count+1