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
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Leet_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode();
        ListNode answer = current;
        int adder = 0;
        while(true){
            int a,b ;
            if ( l1 == null) a = 0; else a = l1.val;
            if ( l2 == null) b = 0; else b = l2.val;
            int sum = a+b+adder;

            if (sum > 9) {
                adder = 1;
                sum = sum % 10;
            }else adder = 0;
            current.val = sum;

            if (l1 != null) l1=l1.next;
            if (l2 != null) l2=l2.next;

            if ( l1 == null && l2 == null)  {
                if(adder == 1) {
                    current.next = new ListNode(1);
                }
                break;
            }
            current.next = new ListNode();


            current = current.next;
        }
        return answer;
    }
}
