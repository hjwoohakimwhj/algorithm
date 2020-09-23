package link;

public class Swap {
    //24
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode p = head.next;
        ListNode q = swapPairs(p.next);
        head.next = q;
        p.next = head;
        return p;
    }

    //61
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int num = 1;
        ListNode c = head;
        while (c.next != null){
            c = c.next;
            num++;
        }
        k = k % num;
        if (k == 0){
            return head;
        }

        ListNode p = head;
        ListNode q = head;
        int count = 0;
        while (p != null){
            p = p.next;
            if (count >= k){
                q = q.next;
            }
            count++;
        }
        ListNode before = head;
        head = q;
        while (q.next != null){
            q = q.next;
        }
        q.next = before;
        while (before.next != head){
            before = before.next;
        }
        before.next = null;
        return head;
    }

    //206
    public ListNode reverseList(ListNode head) {
        //if(head == null || head.next == null){
            //return head;
        //}
        ListNode p = null;
        ListNode q = head;
        while(q != null){
            ListNode qNext = q.next;
            q.next = p;
            p = q;
            q = qNext;
        }
        return p;
    }

    //234
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode cur = slow;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        //pre是反转后的头节点
        ListNode left = head;
        ListNode right = pre;
        //如果是偶数,right为空的时候，left还不为空
        while(right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
