package algorithm;

import java.util.ArrayList;

public class leet148 {
	public static void main(String[] args){
		leet148 test = new leet148();
		ListNode head = new ListNode(1);
		
		ListNode ans = test.sortList(head);
		System.out.println(ans);
	}
	// this is my own method
    public ListNode sortList(ListNode head) {
    		if(head == null ) return head;
        ArrayList<ListNode> array = new ArrayList<>();
        ListNode tmp = head;
        while(tmp!= null){
	        	array.add(tmp);
	        	tmp = tmp.next;
        }
        ArrayList<ListNode> aux = new ArrayList<>();
        for(int i = 0; i< array.size(); i++){
        		aux.add(null);
        }
        mergesort(array,aux,0,array.size()-1);
        for(int i = 0; i< array.size(); i++){
        		if(i == array.size() -1) 
        			array.get(i).next = null;
        		else
        			array.get(i).next = array.get(i+1);
        }
        return array.get(0);
    }
    private void mergesort(ArrayList<ListNode> array, ArrayList<ListNode> aux, int lo, int hi){
    		if(lo>= hi) return;
    		int mid = (lo + hi)/2;
    		mergesort(array,aux,lo,mid);
    		mergesort(array,aux,mid+1,hi);
    		merge(array,aux,lo,mid,hi);
    }
    private void merge(ArrayList<ListNode> array,ArrayList<ListNode> aux, int lo,int mid, int hi){
    		for(int k = lo; k <= hi; k++){
    			aux.set(k, array.get(k));
    		}
    		int i = lo; int j = mid+1;
    		
    		for(int k= lo; k <= hi; k++){
    			if(i>mid) array.set(k, aux.get(j++));
    			else if (j>hi) array.set(k, aux.get(i++));
    			else if (aux.get(i).val < aux.get(j).val ) array.set(k, aux.get(i++));
    			else array.set(k, aux.get(j++));
    		}
    }

    // we now try others method
    public ListNode sortList1(ListNode head) {
        if(head == null || head.next == null) return head;
        
        // 1st step cut the linkedlist into halves
        ListNode slow = head, fast = head, prev = null;
        
        while(fast != null && fast.next != null){
        		prev = slow;
        		slow = slow.next;
        		fast = fast.next.next;
        }
        prev.next = null;
        
        //2nd step sort each half
        ListNode l1 = sortList1(head);
        ListNode l2 = sortList1(slow);
        
        //3rd merge two sorted half;
        return merge1(l1,l2);
    }
    
    private ListNode merge1(ListNode l1, ListNode l2){
    		ListNode head = new ListNode(-1), tmp = head;
    		
    		while(l1 != null && l2 != null){
    			if(l1.val < l2.val){
    				tmp.next = l1;
    				l1 = l1.next;
    			}
    			else{
    				tmp.next = l2;
    				l2 = l2.next;
    			}
    			tmp = tmp.next;
    		}
    		if(l1 != null)
    			tmp.next = l1;
    		if(l2 != null)
    			tmp.next = l2;
    		return head.next;
    }
}
