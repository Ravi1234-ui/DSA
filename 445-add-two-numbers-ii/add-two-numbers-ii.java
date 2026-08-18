import java.util.ArrayDeque;
import java.util.Deque;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Using Deque (ArrayDeque) is recommended over java.util.Stack in modern Java
        Deque<Integer> st1 = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();

        // Push all nodes of l1
        ListNode temp = l1;
        while (temp != null) {
            st1.push(temp.val);
            temp = temp.next;
        }

        // Push all nodes of l2
        temp = l2;
        while (temp != null) {
            st2.push(temp.val);
            temp = temp.next;
        }

        ListNode head = null;
        int carry = 0;

        // Process digits and carry from right to left
        while (!st1.isEmpty() || !st2.isEmpty() || carry != 0) {
            int val1 = !st1.isEmpty() ? st1.pop() : 0;
            int val2 = !st2.isEmpty() ? st2.pop() : 0;

            int total = val1 + val2 + carry;
            carry = total / 10;

            // Create new node with the current digit and prepend to result list
            ListNode newNode = new ListNode(total % 10);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }
}