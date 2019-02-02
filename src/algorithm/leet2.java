package algorithm;

class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){
		this.val = val;

	}
}

public class leet2 {
	//
	public static void main(String [] args){
		
			leet2 test = new leet2();
			ListNode l1 = new ListNode(5);
			ListNode l2 = new ListNode(5);
			//l2.next = new ListNode(3);
			
			System.out.println(test.addTwoNumbers(l1, l2).next.val);
	}
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result; 
        if(l1 == null && l2 == null) return null;
        else if(l1 == null) result = l2;
        else if(l2 == null) result = l1;
        else {
        		int sum = (l1.val + l2.val) % 10;
        		int carry = (l1.val + l2.val) / 10;
        		result = new ListNode(sum);
        		
        		ListNode tmp = result;
        		l1 = l1.next;
        		l2 = l2.next;
        		while(l1 != null || l2 != null || carry != 0){
        			if(l1 == null && l2 != null) {
        				sum = (carry + l2.val)%10;
        				carry = (carry + l2.val)/10;
        				tmp.next =new ListNode(sum);
        				l2 = l2.next;
        				tmp = tmp.next;
        				continue;
        			}
        			else if(l2 == null && l1 != null) {
        				sum = (carry + l1.val)%10;
        				carry = (carry + l1.val)/10;
        				tmp.next =new ListNode(sum);
        				l1 = l1.next;
        				tmp = tmp.next;
        				continue;
        			}
        			else if(l1 == null && l2 == null){
        				tmp.next =new ListNode(carry);
        				carry = 0;
        			}
        			else{
        				sum = (carry + l1.val + l2.val)%10;
        				carry = (carry + l1.val + l2.val)/10;
        				tmp.next =new ListNode(sum);
        				l1 = l1.next;
        				l2 = l2.next;
            			tmp = tmp.next;
        			}
        		}
        		
        }
        return result;
    }
}
