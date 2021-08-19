package lianbiao;

public class ListNode {


    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

   static ListNode builder(int[] nums){
        ListNode node = new ListNode(nums[0]);
        ListNode head  = node;
        for (int i=1;i<nums.length;i++){
            ListNode newNode = new ListNode(nums[i]);
            node.next = newNode;
            node = newNode;
        }
        return head;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String outString(){
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        while (node.next != null){
            ListNode node1 = node.next;
            sb.append(",").append(node1.val);
            node = node1;
        }
        return sb.toString();
    }
}
