package algorithm;

public class leet234 {
public boolean isPalindrome(ListNode head) {
	
		if(head == null )return false;
		
        // here assume that we can change the input
	    // 1st   cut the list by half
		ListNode slow=head, fast = head;
		while(fast != null && fast.next !=null ){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null) slow = slow.next;  //even node
		slow = reverse(slow);
		fast = head;
		
		while(slow != null){
			if(fast.val != slow.val) return false;
			fast = fast.next;
			slow = slow.next;
		}
		return true;
    }

private ListNode reverse(ListNode head){
	ListNode pre = null;
	ListNode curr = head;
	ListNode tmp;
	while(curr != null){
		tmp = curr;
		curr = curr.next;
		tmp.next = pre;
		pre = tmp;
	}
	return pre;
}

}
