package nowcoder.code.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/8/28
 */
public class Bm13Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode4;
//        listNode3.next = listNode4;
        Bm13Solution solution = new Bm13Solution();
        System.out.println(solution.isPail3(listNode1));
        System.out.println(solution.isPail3(new ListNode(2)));
    }

    /**
     * 先将正序的值算出来，存到数组里，再翻装，将逆序的值算出来放到数组，比较这两个数组是否相等。
     * 时间复杂度O(1),空间复杂度O(n)
     * @param head
     * @return
     */
    public boolean isPail(ListNode head) {
        List<Integer> list = calVal(head);
        ListNode reverse = reverse(head);
        List<Integer> reverseList = calVal(reverse);
        for (int i = 0; i < list.size(); i++) {
            if(!reverseList.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将正序的数组算出来，然后直接根据数组算是否是回文
     * @param head
     * @return
     */
    public boolean isPail2(ListNode head) {
        List<Integer> list = calVal(head);
        for (int i = 0; i < list.size() / 2; i++) {
            if(!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用快慢指针找到中点，然后将中点之前的结点翻转
     * 再比较中点之前和之后的结点是否一样
     * 时间复杂度 O(1), 空间复杂度 O(1)
     * @param listNode
     * @return
     */
    public boolean isPail3(ListNode listNode) {
        ListNode midPoint = findMidPoint(listNode);
        reverse(listNode, midPoint);
        ListNode p = listNode;
        ListNode q = midPoint.next;
        while (q != null) {
            if(p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    private ListNode findMidPoint(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 将startNode之后所有的结点翻转（不包含startNode）
     * @param head
     * @param startNode
     * @return
     */
    private void reverse(ListNode head, ListNode startNode) {
        ListNode p = startNode.next;
        if(p == null) {
            return;
        }
        while (p.next != null) {
            // 将p.next从p后面挪到startNode的后面
            ListNode pNext = p.next;
            // 先从p后面删掉
            p.next = pNext.next;
            // 再插入到startNode的后面
            ListNode startNodeNext = startNode.next;
            startNode.next = pNext;
            pNext.next = startNodeNext;
        }
    }
    private List<Integer> calVal(ListNode head) {
        List<Integer> re = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            re.add(p.val);
            p = p.next;
        }
        return re;
    }

    private ListNode reverse(ListNode listNode) {
        ListNode preHead = new ListNode(0);
        preHead.next = listNode;
        ListNode p = listNode;
        while (p.next != null) {
            // 将p.next从p的后端挪到preHead的后面。
            // 先将p.next删掉
            ListNode pNext = p.next;
            p.next = p.next.next;
            // 再将p.next插入到preHead的后面
            ListNode preHeadNext = preHead.next;
            preHead.next = pNext;
            pNext.next = preHeadNext;
        }
        return preHead.next;
    }
}
