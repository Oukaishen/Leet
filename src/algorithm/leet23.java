package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leet23 {
	    // fuck, my method pass 129/130 algorithm.test. WTF.-.-
	    // fuck, i am so stupid, can break if l1 is null in while
//	    public ListNode mergeKLists(ListNode[] lists) {
//	        if(lists.length == 1) return lists[0];
//	        else{
//	        		ListNode res = null;
//	        		for(int i = 0; i<lists.length;i++){
//	        			res = merge2Lists(res,lists[i]);
//	        		}
//	        		return res;
//	        }
//	    }
//	    
//	    private ListNode merge2Lists(ListNode l1, ListNode l2){
//	    		if(l1 == null)
//	    			return l2;
//	    		if( l2 == null)
//	    			return l1;
//	    		ListNode res;
//	    		if(l1.val < l2.val){
//	    			res = l1;
//	    			l1 = l1.next;
//	    		}
//	    		else{
//	    			res = l2;
//	    			l2 = l2.next;
//	    		}
//	    		ListNode tmp = res;
//	    		while(l1 != null || l2 != null){
//	    			//4 cases
//	    			if(l1 == null){
//	    				tmp.next = l2;
////	    				tmp = tmp.next;
////	    				l2 = l2.next;
//	    				//continue;
//	    				break;
//	    			}
//	    			else if(l2 == null){
//	    				tmp.next = l1;
////	    				tmp = tmp.next;
////	    				l1 = l1.next;
//	    				break;
//	    			}
//	    			else if(l1.val < l2.val){
//	    				tmp.next = l1;
//	    				tmp = tmp.next;
//	    				l1 = l1.next;
//	    			}
//	    			else{
//	    				tmp.next = l2;
//	    				tmp = tmp.next;
//	    				l2 = l2.next;
//	    			}
//	    		}
//	    		return res;
//	    }
	 public ListNode mergeKLists2(ListNode[] lists) {
		 if(lists.length == 0) return null;
		 if(lists.length == 1) return lists[0];
		 PriorityQueue<ListNode> que = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
			 @Override
			 public int compare(ListNode o1, ListNode o2){
				 if(o1.val < o2.val) return -1;
				 else if(o1.val > o2.val) return 1;
				 else return 0;
			 }
		 });
		 
		 for(ListNode node:lists){
			if(node != null){
				que.offer(node);
			}
		 }
		 
		 ListNode res =new ListNode(-1);
		 ListNode tmp = res;
		 while(!que.isEmpty()){
//			 ListNode node = que.poll();
//			 if(node.next != null)
//				 que.offer(node.next);
//			 tmp.next = node;
//			 tmp = tmp.next;
		     tmp.next = que.poll();
		     tmp = tmp.next;
		     if(tmp.next!= null)
		    	 	que.offer(tmp.next);
			 
		 }
		 return res.next;
	 }
}
