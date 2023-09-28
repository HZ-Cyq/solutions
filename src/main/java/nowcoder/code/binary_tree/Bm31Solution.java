package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/21
 */
public class Bm31Solution {

    public static void main(String[] args) {
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        //
        if(pRoot == null) {
            return true;
        }
        return isSym(pRoot.left, pRoot.right);
    }

    public boolean isSym(TreeNode node1, TreeNode node2) {
        // 都为空，返回true
        if(node1 == null && node2 == null) {
            return true;
        }
        // 只有一个为空，返回false
        if(node1 == null || node2 == null) {
            return false;
        }
        // 都不为空，值不相等，返回false
        if(node1.val != node2.val) {
            return false;
        }
        // 判断该结点的左右孩子是否相等
        return isSym(node1.left, node2.right) && isSym(node1.right, node2.left);
    }
}
