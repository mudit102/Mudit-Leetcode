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
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Push values of l1 into stack1
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        // Push values of l2 into stack2
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sumVal = carry;

            // Add the top values from stack1 and stack2, if available
            if (!stack1.isEmpty()) {
                sumVal += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sumVal += stack2.pop();
            }

            // Create a new node with the sum % 10
            ListNode node = new ListNode(sumVal % 10);

            // Set the new node as the next node of the result list
            node.next = result;
            result = node;

            // Update the carry
            carry = sumVal / 10;
        }

        return result;
    }
}
