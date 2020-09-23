package link;

public class Cycle {
    //141.
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("in while: slow is " + slow.val);
            System.out.println("in while: fast is " + fast.val);
            if(slow == fast){
                break;
            }
        }
        if(slow != fast){
            return null;
        }
        System.out.println("slow value is " + slow.val);

        ListNode target = head;
        while(target != slow){
            target = target.next;
            slow = slow.next;
        }
        return slow;
    }

    //142
    public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow != fast){
            return null;
        }

        ListNode target = head;
        while(target != slow){
            target = target.next;
            slow = slow.next;
        }
        return slow;
    }
}
