package nowcoder.code.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/20
 */
public class Bm24Solution {
    public static void main(String[] args) {

    }

    /************************************************/
    // 递归的方法
    public int[] inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inorderTraversal1(root, results);
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    public void inorderTraversal1(TreeNode node, List<Integer> list) {
        if(node == null) {
            return ;
        }
        inorderTraversal1(node.left, list);
        list.add(node.val);
        inorderTraversal1(node.right, list);
    }

    /************************************************/
    // 迭代的方法
    public int[] inorderTraversal2(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        // 每迭代一次，会将最左边的孩子结点打印出来
        // 将最左孩子的右孩子入栈，将当前结点更新该右孩子结点
        while (temp != null || !stack.isEmpty()) {
            // 将temp到最左孩子途经的所有结点入栈
            while (temp!= null) {
                stack.push(temp);
                temp = temp.left;
            }
            // 走到这，temp一定是空的
            TreeNode leftMost = stack.pop();
            result.add(leftMost.val);
            if(leftMost.right != null) {
                temp = leftMost.right;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
