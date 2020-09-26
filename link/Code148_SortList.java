package link;

public class Code148_SortList {
    //7.84% 7.09%
    public ListNode sortList(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        process(head, sentinel, null);
        return sentinel.next;
    }

    public void process(ListNode node, ListNode before, ListNode after){
        if(node == null){
            return;
        }
        if(node.next == after){
            return;
        }
        if(node == after){
            return;
        }
        ListNode cur = node.next;
        ListNode nodeBefore = before;
        ListNode nodeAfter = node;
        while(cur != after){
            if(cur.val >= node.val){
                nodeAfter = cur;
                cur = cur.next;
            }else{
                ListNode newCur = cur.next;
                before.next = cur;
                if(before == nodeBefore){
                    nodeBefore = cur;
                    cur.next = node;
                }else{
                    cur.next = nodeBefore;
                    nodeBefore = cur;
                }
                cur = newCur;
                nodeAfter.next = cur;
            }
        }
        process(before.next, before, node);
        //node.next 可能为空，所以这个函数的开始要判断node是否为空
        process(node.next, node, after);
    }

    //39.78% 10.95%
    public ListNode sortList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode c = head;
        int count = 0;
        while(c != null){
            c = c.next;
            count++;
        }
        System.out.println("count is " + count);
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        int level = 1;
        while(count > level){
            System.out.println("============leve is " + level + " ===============");
            ListNode before = sentinel;
            ListNode cur = before;
            ListNode p = before.next;
            ListNode q = p;
            ListNode qStop = q;
            ListNode pStop;
            for(int j = 0; j < (count/(level * 2) + 1); j++){
                System.out.println("j is " + j);
                if(j == (count/(level * 2))){
                    if(count <= (level * (2 * j +1))){
                        continue;
                    }
                    for(int i = 0; i < level; i++){
                        q = q.next;
                    }
                    qStop = null;
                }else{
                    for(int i = 0; i < level; i++) {
                        q = q.next;
                        qStop = qStop.next.next;
                    }
                }
                pStop = q;
                if(qStop != null){
                    System.out.println("p stop is " + pStop.val + " q stop is " + qStop.val);
                }else{
                    System.out.println("p stop is " + pStop.val + " q stop is null");
                }
                while(p != pStop && q != qStop){
                    if(p.val <= q.val){
                        System.out.println("link p , p is " + p.val);
                        cur.next = p;
                        p = p.next;
                    }else{
                        System.out.println("link q , q is " + q.val);
                        cur.next = q;
                        q = q.next;
                    }
                    cur = cur.next;
                }
                if(p == pStop){
                    System.out.println("p stop first");
                    cur.next = q;
                    cur = cur.next;
                    while(cur.next != qStop){
                        cur = cur.next;
                    }
                    System.out.println("cur is " + cur.val);
                }else{
                    cur.next = p;
                    cur = cur.next;
                    while(cur.next != pStop){
                        cur = cur.next;
                    }
                    cur.next = qStop;
                    System.out.println("cur is " + cur.val);
                }
                p = qStop;
                q = qStop;
            }
            level *= 2;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        int[] array = {-84,142,41,-17,-71,170,186,183,-21,-76,76,10,29,81,112,-39,-6,-43,58,41,111,33,69,97,-38,82,-44,-7,99,135,42,150,149,-21,-30,164,153,92,180,-61,99,-81,147,109,34,98,14,178,105,5,43,46,40,-37,23,16,123,-53,34,192,-73,94,39,96,115,88,-31,-96,106,131,64,189,-91,-34,-56,-22,105,104,22,-31,-43,90,96,65,-85,184,85,90,118,152,-31,161,22,104,-85,160,120,-31,144,115};
        ListNode head = ListNode.genList(array);
        Code148_SortList sortList = new Code148_SortList();
        ListNode node = sortList.sortList2(head);
        System.out.println("==============================================");
        ListNode.printList(node);
    }
}
