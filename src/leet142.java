package algorithm;

public class leet142 {
	public ListNode detectCycle(ListNode head) {
       // detect whether there is a cycle and if there is, give out the entry point
		// dont afraid son, just do this
		if(head == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		while( fast.next!= null && fast.next.next != null  ){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				slow = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
    }
}
