package algorithm;

public class leet206 {
	// again, don't afraid but just do this.
public ListNode reverseList(ListNode head) {
        if(head == null ) return head;
        ListNode tmpNode1 = null;
        ListNode tmpNode2 = null;
        
        while(true){
	        tmpNode1 = head.next;
	        if(tmpNode1 == null){
	        		head.next = tmpNode2;
	        		return head;
	        }
	        else{
	        		 head.next = tmpNode2;
	        		 tmpNode2 = head;
	        		 head = tmpNode1;
	        }
        }
        
    }
}
