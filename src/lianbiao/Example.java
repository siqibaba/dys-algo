package lianbiao;

import java.util.HashMap;
import java.util.Map;

public class Example {

    public ListNode reverseList(ListNode head) {
        if (head == null ) return null;
        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null;
        while (current != null ){
            ListNode next  = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < left; i++) {
            head = head.next;
        }
        ListNode prevM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;
        for(int i = left; i < right; i++) {
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        mNode.next = postN;
        prevM.next = nNode;
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null ) return null;
        Map<Node, Node> map = new HashMap<>();
        Node newHead = head;
        while (newHead != null ){
            if (!map.containsKey(newHead)){
                Node node = new Node(newHead.val);
                map.put(newHead,node);
            }
            if (newHead.random != null){
                Node random = newHead.random;
                if (!map.containsKey(newHead.random)){
                    Node copyRandom = new Node(newHead.random.val);
                    map.put(newHead.random,copyRandom);
                }
                map.get(newHead).random = map.get(random);
            }
            newHead = newHead.next;
        }
        newHead = head;
        while (newHead != null) {
            Node next = newHead.next;
            map.get(newHead).next = map.get(next);
            newHead = newHead.next;
        }
        return map.get(head);
    }
    public static void main(String[] args) {
        Example example = new Example();

        ListNode node = ListNode.builder(new int[]{1,2,3,4,5});
//        System.out.println(node.outString());
        System.out.println(example.reverseBetween(node,2,4).outString());
//        System.out.println(example.reverseList(node).outString());
    }

}
