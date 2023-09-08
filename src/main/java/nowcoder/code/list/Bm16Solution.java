package nowcoder.code.list;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/8/28
 */
public class Bm16Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
//        ListNode listNode4 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        Bm16Solution bm16Solution = new Bm16Solution();
        ListNode listNode = bm16Solution.deleteDuplicates(listNode1);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates (ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode p = preHead;
        // 如果p.next的值和p.next.next值一样，p.next和p.next.next以及之后所有值一样的结点从链表中删掉
        while (p.next != null && p.next.next != null) {
            if(p.next.val == p.next.next.val) {
                ListNode q = p;
                int val = p.next.val;
                // 将p之后所有相同的结点删掉。
                while (q.next != null && q.next.val == val) {
                    q.next = q.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return preHead.next;
    }
}
