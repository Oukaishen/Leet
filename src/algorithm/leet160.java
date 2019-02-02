package algorithm;

public class leet160 {
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null ) return null;
		
        ListNode tmpNode = headA;
        int a = 0;
        while(tmpNode != null){
        		a++;
        		tmpNode = tmpNode.next;
        }
        
        tmpNode = headB;
        int b = 0;
        while(tmpNode != null){
        		b++;
        		tmpNode = tmpNode.next;
        }
        
        if(a < b){
        		tmpNode = headA;
        		headA = headB;
        		headB = tmpNode;
        }
        
        for(int i = 0; i< Math.abs(a-b) ; i++){
        		headA = headA.next;
        }
        
        while(headA != null && headB != null){
        		if(headA == headB) return headA;
        		headA = headA.next;
        		headB = headB.next;
        }
        return null;
    }

// clever solution
public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
	if(headA == null || headB == null) return null;
	
	ListNode a = headA;
	ListNode b = headB;
	
	while(a != b ){
		a = a == null? headB: a.next;
		b = b == null? headA: b.next;
	}
	
	return a;
}

}
