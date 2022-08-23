import org.junit.Test;

/**
 * @author playcrab_chenyuqun
 */
public class AA {
    /**
     * https://leetcode-cn.com/problems/merge-sorted-array/
     */
    public void testMergeSortedArrays() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1,3,nums2,3);
        for(int i = 0; i < 6; i++) {
            System.out.printf("%d ",nums1[i]);
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length;
        if(length < m + n) {
            return ;
        }
        for(int i = m; i < length;i ++) {
            nums1[i] = 0;
        }
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(k >= 0) {
            if(i >= 0 && j >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                if(j < 0) {
                    break;
                }
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public void testMergeTowSortedLists(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;

        mergeTwoLists(n1,n4);

        while(n1 != null) {
            System.out.printf("%d ",n1.val);
            n1 = n1.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1.val <= l2.val? l1 : l2;
        ListNode q = p == l1 ? l2 : l1;
        while(p!= null && q!=null) {
            while(p.val < q.val && p.next != null&& p.next.val < q.val) {
                p = p.next;
            }
            if(p.next != null) {
                ListNode new_q = q.next;
                q.next = p.next;
                p.next = q;
                p = q;
                q = new_q;
            } else {
                p.next = q;
                break;
            }
        }
        return p;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public void testBase() {
        int[] array = new int[10];
        System.out.printf("%d\n",array.length);
    }
}
