/*
2. Add Two Numbers
Medium
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode list = head;
        int carry = 0;
        while(l1!=null || l2!=null) {
            int val = 0;
            if(l1!=null) {
                val=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                val += l2.val;
                l2 = l2.next;
            }
            list.val=(val + carry)%10;
            carry=(val + carry)/10;
            if(l1!= null || l2 != null) {
                list.next = new ListNode();
                list = list.next;
            }
        }
        if (carry > 0) {
            list.next = new ListNode(carry);
        }
        return head;
    }
}
/*
Possible questions: Least significant digit on the tail of list
*/