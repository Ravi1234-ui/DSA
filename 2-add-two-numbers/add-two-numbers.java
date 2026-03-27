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
class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode temp1=head1,temp2=head2;
		int carry=0;
		ListNode dummyNode=new ListNode(-1),curr=dummyNode;
		while(temp1!=null || temp2!=null) {
			int sum=carry;
			if(temp1!=null) sum+=temp1.val;
			if(temp2!=null) sum+=temp2.val;
			
			ListNode newNode=new ListNode(sum%10);
			curr.next=newNode;
			curr=curr.next;
			carry=sum/10;
			if(temp1!=null) temp1=temp1.next;
			if(temp2!=null) temp2=temp2.next;
		}
        if(carry>0) curr.next = new ListNode(carry);
		return dummyNode.next;
    }
}