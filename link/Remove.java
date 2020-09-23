package link;

public class Remove {
    //19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode cur = head;
        ListNode q = head;
        int count = 0;
        while(q != null){
            q = q.next;
            if(count == n){
                p = cur;
                cur = cur.next;
            }else{
                count++;
            }
        }
        if(p == cur){
            head = cur.next;
        }else{
            p.next = cur.next;
        }
        return head;
    }

    //̼2
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pre = sentinel;
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            if(p.val != q.val){
                if(q != p.next){
                    pre.next = q;
                    p = q;
                    q = q.next;
                }else{
                    pre = p;
                    p = p.next;
                    q = q.next;
                }
            }else{
                q = q.next;
            }
        }
        if(p.next != null){
            pre.next = null;
        }
        return sentinel.next;
    }

    //82.2
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            //注意，head.next为空时，再去取val会报错
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }


    //203.
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while(q != null){
            if(q.val == val){
                if(p == q){
                    head = q.next;
                    p = head;
                    q = head;
                }else{
                    p.next = q.next;
                    q = p.next;
                }
            }else{
                p = q;
                q = q.next;
            }
        }
        return head;
    }

    //203.2 利用哨兵节点
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode p = sentinel;
        ListNode q = sentinel.next;
        while(q != null){
            if(q.val == val){
                p.next = q.next;
                q = p.next;
            }else{
                p = q;
                q = q.next;
            }
        }
        return sentinel.next;
    }
}
