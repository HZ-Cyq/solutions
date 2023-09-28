package nowcoder.code.binary_tree;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/28
 */
public class Bm37Solution {
    public static void main(String[] args) {

    }

    enum STATE {
        NONE, HAS_P, HAS_Q, ALL;
    }

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        int min = Math.min(p, q);
        int max = Math.max(p, q);
        TreeNode temp = root;
        while (true) {
            if(temp.val >= min && temp.val <= max) {
                return temp.val;
            }
            if(temp.val < min) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
    }

}
