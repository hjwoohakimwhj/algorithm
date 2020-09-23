package link;

public class Merge {
    //21
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode p1 = l1;
        ListNode q1 = l1;
        ListNode p2 = l2;
        ListNode q2 = l2;

        boolean start1 = p1.val <= p2.val;

        while(q1 != null && q2 != null){
            if(q1.val <= q2.val){
                //System.out.println("q1 is " + q1.val);
                //System.out.println("q2 is " + q2.val);
                p1 = q1;
                q1 = q1.next;
                if((q1 == null) || (q1.val > q2.val)){
                    p1.next = q2;
                }
            }else{
                p2 = q2;
                q2 = q2.next;
                if((q2 == null) || (q2.val >= q1.val)){
                    p2.next = q1;
                }
            }
        }
        return start1 ? l1 : l2;
    }
    //21.2
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 3, 4};
        ListNode l1 = ListNode.genList(array1);
        ListNode l2 = ListNode.genList(array2);
        ListNode head = Merge.mergeTwoLists(l1, l2);
        ListNode.printList(head);


    }
}
