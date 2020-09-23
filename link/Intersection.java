package link;

public class Intersection {
    //160.
    public ListNode getIntersectionNodeMy(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode ap = headA;
        ListNode bp = headB;
        while(ap != null && bp != null){
            if(ap == bp){
                //两个链表就是同一个链表（head）或者两个链条长度相同
                return ap;
            }
            ap = ap.next;
            bp = bp.next;
        }

        if(ap == null){
            ap = headB;
            while(bp != null){
                bp = bp.next;
                ap = ap.next;
            }
            bp = headA;
            while(bp != null){
                if(ap == bp){
                    return bp;
                }
                ap = ap.next;
                bp = bp.next;
            }
            //两条链表无相交
            if(bp == null){
                return null;
            }
        }
        if(bp == null){
            bp = headA;
            while(ap != null){
                ap = ap.next;
                bp = bp.next;
            }
            ap = headB;
            while(ap != null){
                if(ap == bp){
                    return ap;
                }
                ap = ap.next;
                bp = bp.next;
            }
            if(ap == null){
                return null;
            }
        }
        return null;
    }

    //160.1
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Intersection.getIntersectionNode(n1, n4);
    }
}
