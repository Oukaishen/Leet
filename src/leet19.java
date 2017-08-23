package algorithm;

public class leet19 {
public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null ) return head;
        ListNode fast = head;
        for(int i = 1; i< n; i++){
        		fast = fast.next;
        }
        ListNode par = null;
        ListNode res = head;
        while(fast.next != null){
        		fast = fast.next;
        		par = head;
        		head = head.next;
        }
        
        if(par == null)
        		return head.next;
        else
        {
        		par.next = head.next;
        		return res;
        }
    }
}
