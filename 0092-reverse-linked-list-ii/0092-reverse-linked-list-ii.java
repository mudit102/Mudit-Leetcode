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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a list to store the values of the linked list
        List<Integer> valueList = new ArrayList<Integer>();
        
        // Traverse the linked list and store its values in the list
        ListNode current = head;
        while (current != null) {
            valueList.add(current.val);
            current = current.next;
        }
        
        int shift = 0; // Initialize a shift variable to handle reversing
        
        // Reverse the sublist from 'left' to 'right' in the value list
        for (int i = left - 1; i < right && i < right - 1 - shift; i++) {
            int num1 = valueList.get(i);
            int num2 = valueList.get(right - 1 - shift);
            
            // Swap the values in the value list
            valueList.set(i, num2);
            valueList.set(right - 1 - shift, num1);
            
            shift++;
        }
        
        // Update the original linked list with the modified values
        current = head;
        int ptr = 0;
        while (current != null) {
            current.val = valueList.get(ptr++);
            current = current.next;
        }
        
        return head;
    }
}