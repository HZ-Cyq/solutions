package nowcoder.code.list;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/8/28
 */
public class Bm15Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        Bm15Solution bm15Solution = new Bm15Solution();
        bm15Solution.deleteDuplicates(listNode1);
        System.out.println(listNode1);
    }

    public ListNode deleteDuplicates (ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode p = head;
        // p后面的元素和自己相等的时候，把p后面的元素从链表里删掉
        while (p.next != null) {
            if(p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
