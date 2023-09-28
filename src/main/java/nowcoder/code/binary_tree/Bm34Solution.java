package nowcoder.code.binary_tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/27
 */
public class Bm34Solution {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(4);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        Bm34Solution bm34Solution = new Bm34Solution();
        System.out.println(bm34Solution.isValidBST(treeNode1));
    }
    public boolean isValidBST (TreeNode root) {
        // write code here
        return isValidBST(root, new ArrayList<>());
    }

    /**
     * 中序遍历，val是遍历到的节点的值
     * @param root
     * @param result 遍历的值加入result数组中
     * @return
     */
    public boolean isValidBST(TreeNode root, List<Integer> result) {
        if(root == null) {
            return true;
        }
        if(root.left != null) {
            boolean validBST = isValidBST(root.left, result);
            if(!validBST) {
                return false;
            }
        }
        if(!result.isEmpty() && result.get(result.size() - 1) > root.val) {
            return false;
        }
        result.add(root.val);
        return isValidBST(root.right, result);
    }
}
