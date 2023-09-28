package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/28
 */
public class Bm38Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;

        Bm38Solution bm38Solution = new Bm38Solution();
        System.out.println(bm38Solution.lowestCommonAncestor(node1, 5, 1));
    }

    /**
     *
     * @param root
     * @param o1
     * @param o2
     * @return -1:都没有
     *         -2:有o1
     *         -3:有o2
     *         大于零:都有
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(o1 == o2) {
            return o1;
        }
        if(root == null) {
            return -1;
        }
        // 基础情况
        if(root.left == null && root.right == null) {
            return calResult(root.val, o1, o2);
        }
        // 递归情况
        int leftResult = lowestCommonAncestor(root.left, o1, o2);
        if(leftResult > 0) {
            return leftResult;
        }
        int rightResult = lowestCommonAncestor(root.right, o1, o2);
        if(rightResult > 0) {
            return rightResult;
        }
        // 左右都没有
        if(leftResult == -1 && rightResult == -1) {
            return calResult(root.val, o1, o2);
        }
        if((leftResult == -2 && rightResult == -3) || (leftResult == -3 && rightResult == -2)) {
            return root.val;
        }
        // 左边没有
        if(leftResult == -1) {
            if((rightResult == -2 && root.val == o2) || (rightResult == -3 && root.val == o1)) {
                return root.val;
            }
            return rightResult;
        }else if(rightResult == -1) {
            if((leftResult == -2 && root.val == o2) || (leftResult == -3 && root.val == o1)) {
                return root.val;
            }
            return leftResult;
        }
        return -1;
    }

    private int calResult(int val, int o1, int o2) {
       if(val == o1) {
           return -2;
       } else if(val == o2) {
           return -3;
       } else {
           return -1;
       }
    }
}
