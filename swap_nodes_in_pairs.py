# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class SwapPairs:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        '''
        1 2 3 4
        '''

        prev = ListNode()
        root=prev
        cur=head
        while cur!=None and cur.next!=None:
            first=cur
            second=cur.next
            prev.next=second
            first.next=second.next
            second.next=first

            prev=first
            cur=first.next

        return root.next if root.next!=None else head