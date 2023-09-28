package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/27
 */
public class Bm33Solution {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(11);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        Bm33Solution bm33Solution = new Bm33Solution();
        TreeNode mirror = bm33Solution.Mirror(treeNode1);
        System.out.println(mirror);
    }

    /**
     * 后序遍历
     * @param pRoot
     * @return
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null) {
            return null;
        }
        if(pRoot.left == null && pRoot.right == null) {
            return pRoot;
        }
        // ！！注意这里加个指针指向之前的left
        TreeNode preLeft = pRoot.left;
        // pRoot不为空，且其左右孩子节点也不为空
        pRoot.left = Mirror(pRoot.right);
        pRoot.right = Mirror(preLeft);
        return pRoot;
    }
}
