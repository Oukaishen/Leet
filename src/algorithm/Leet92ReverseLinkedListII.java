package algorithm;

import java.util.List;

public class Leet92ReverseLinkedListII {

    public static void main(String [] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(reverseBetween(n1,2,4));

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null ) return null;

        // for iteration
        ListNode iterPtr = head;
        int curNode = 1;

        // m -1 node
        ListNode beforeReverse = head;

        // m node
        ListNode mNode = null;

        // n+1 node
        ListNode afterRevers = null;

        // the m - 1 node, do nothing
        while(curNode < m ) {
            if(curNode == m -1)
                beforeReverse = iterPtr;
            curNode++;
            iterPtr = iterPtr.next;
        }

        mNode = iterPtr;

        // do reverse
        ListNode tmp1 = null, tmp2 = null;
        while( curNode <= n ){
            tmp2 = iterPtr.next;
            iterPtr.next = tmp1;
            tmp1 = iterPtr;
            iterPtr = tmp2;
            curNode++;
        }

        mNode.next = iterPtr;
        beforeReverse.next = tmp1;

        return  head;

    }


}
