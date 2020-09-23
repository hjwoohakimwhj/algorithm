package link;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }

    public static ListNode genList(int[] array){
        if(array == null || array.length == 0){
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for(int i = 1; i < array.length; i++){
            ListNode node = new ListNode(array[i]);
            p.next = node;
            p = p.next;
        }
        return head;
    }

    public static void printList(ListNode head){
        ListNode p = head;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        ListNode result = Cycle.detectCycle(n1);
        System.out.println(result.val);

        System.out.println("=================================");
        int[] nodes = {1, 2, 4};
        ListNode head = ListNode.genList(nodes);
        ListNode p = head;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }

    }
}
