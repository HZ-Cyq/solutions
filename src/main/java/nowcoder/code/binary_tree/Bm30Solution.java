package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/20
 */
public class Bm30Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Bm30Solution bm30Solution = new Bm30Solution();
        TreeNode convert = bm30Solution.Convert(node1);
        while (convert != null) {
            System.out.println(convert.val);
            convert = convert.right;
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        return covert0(pRootOfTree);
    }

    /**
     * node的左右都转换成了双向链表
     * @param node
     * @return
     */
    public TreeNode covert0(TreeNode node) {
        TreeNode re = node;
        if(node.left != null) {
            TreeNode left = covert0(node.left);
            TreeNode temp = left;
            while (temp.right != null) {
                temp = temp.right;
            }
            // 此时temp是最左边的一个结点
            node.left = temp;
            temp.right = node;
            re = left;
        }
        if(node.right != null) {
            TreeNode right = covert0(node.right);
            node.right = right;
            right.left = node;
        }
        return re;

    }

}
