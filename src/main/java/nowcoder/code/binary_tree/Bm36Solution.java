package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/27
 */
public class Bm36Solution {
    public static void main(String[] args) {

    }

    public boolean IsBalanced_Solution (TreeNode pRoot) {
        return calHeight(pRoot) > 0;
    }

    /**
     * 计算结点的高度，返回-1代表该结点不平衡
     * @param node
     * @return
     */
    public int calHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int lHeight = calHeight(node.left);
        int rHeight = calHeight(node.right);
        if(lHeight == -1 || rHeight == -1) {
            return -1;
        }
        if(Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }
        return Math.max(lHeight, rHeight) + 1;
    }
}
