package nowcoder.code.list;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/8/28
 */
public class Bm14Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);


        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Bm14Solution bm14Solution = new Bm14Solution();
        ListNode listNode = bm14Solution.oddEvenList(listNode1);
        System.out.println(listNode);
    }
    public ListNode oddEvenList (ListNode head) {
        ListNode p = head;
        ListNode q = head.next;
        // 将q.next结点挪到p后面
        while (q!= null && q.next != null) {
            // 现将q.next从链表中删除
            ListNode qNext = q.next;
            q.next = qNext.next;
            // 再将qNext插入到p后面
            ListNode pNext = p.next;
            p.next = qNext;
            qNext.next = pNext;
            // p，q都往后挪一位
            p = p.next;
            q = q.next;
        }
        return head;
    }
}
