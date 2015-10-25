/*
ou are given two linked lists representing two non-negative numbers. 

The digits are stored in reverse order and each of their nodes contain a single digit. 

Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/*
There are two ways to solve this problem:

1.add digit one by one 

2.transfer the linkedlist to number, add number and transfer the result 

back to a new Linkedlist. But this method cannot handle very large number.

<Boundary Conditions>

1. l1 and l2 are all null: return null

2. digit might larger than 9: throw exception ?

*/

/************* Method 1 ****************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 		if (l1 == null || l2 == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry == 1) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            
            // create a new node and add it to the tail.
            ListNode cur = new ListNode(sum % 10);
            tail.next = cur;
            tail = tail.next;
        }
        
        return dummy.next;
	}
}


/************* Method 2 ****************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int num1 = 0, num2 = 0, sum = 0;
		int ten = 1;
		
        while(l1 != null)	{
        	num1 += l1.val*ten;
        	l1 = l1.next;
        	ten *= 10;
        }
        
        ten = 1;
        while(l2 != null)	{
        	num2 += l2.val*ten;
        	l2 = l2.next;
        	ten *= 10;
        }
        
        sum = num1 + num2;
        ListNode list = new ListNode(0);
        ListNode head = list;
        while(sum != 0)	{
        	list.next = new ListNode(sum%10);
        	list = list.next;
        	sum  = (sum - sum%10)/10;
        } 
        if(head.next == null)
            list.next = new ListNode(0);
        return head.next;
	}
}