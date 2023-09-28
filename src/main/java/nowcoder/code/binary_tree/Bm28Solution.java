package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/20
 */
public class Bm28Solution {
    public static void main(String[] args) {

    }


    /******************************/
    // 递归的方法
    public int maxDepth1 (TreeNode root) {
        // write code here
        return maxDepth0(root);
    }

    public int maxDepth0(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(maxDepth0(node.left), maxDepth0(node.right)) + 1;
    }
}
