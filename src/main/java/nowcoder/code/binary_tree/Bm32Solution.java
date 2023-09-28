package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/25
 */
public class Bm32Solution {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1 == null && t2 == null) {
            return null;
        }
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        // t1和t2都不为空
        TreeNode t = new TreeNode(t1.val + t2.val);
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }

}
