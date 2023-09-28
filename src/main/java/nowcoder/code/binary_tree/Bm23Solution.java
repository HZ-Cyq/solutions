package nowcoder.code.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/12
 */
public class Bm23Solution {

    public static void main(String[] args) {
    }
    public int[] preorderTraversal (TreeNode root) {
//        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        preorderTraversal0(root, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 使用递归的方法进行前序遍历
     * @param root
     * @param result
     */
    public void preorderTraversal0(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        if(root.left != null) {
            preorderTraversal0(root.left, result);
        }
        if(root.right != null) {
            preorderTraversal0(root.right, result);
        }
    }

    /**
     * 使用迭代的方法进行遍历
     */
    public int[] preorderTraversal1(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        List<Integer> re = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 每一次迭代，都将stack栈顶元素弹出，并且其右孩子和左孩子结点弹出
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            re.add(pop.val);
            if(pop.right != null) {
                stack.push(pop.right);
            }
            if(pop.left != null) {
                stack.push(pop.left);
            }
        }
        return re.stream().mapToInt(Integer::intValue).toArray();
    }
}
