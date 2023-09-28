package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/20
 */
public class Bm29Solution {
    public static void main(String[] args) {

    }
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        return hasPathSum0(root, sum);
    }

    public boolean hasPathSum0(TreeNode root, int num) {
        if(root == null) {
            return false;
        }
        // 当前结点值是num并且是叶子结点，返回true
        if(root.val == num && root.left == null && root.right == null) {
                return true;
        }
        // 否则需要计算其左右结点是否有和为num - root.val的
        return hasPathSum(root.left, num - root.val) || hasPathSum(root.right, num - root.val);
    }
}
