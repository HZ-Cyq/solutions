package nowcoder.code.binary_tree;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/27
 */
public class Bm35Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        Bm35Solution bm35Solution = new Bm35Solution();
        System.out.println(bm35Solution.isCompleteTree(node1));
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 一层的结点，从左到右依次入队
            boolean end = false;
            // !! 这里的size在遍历前需要写死，因为遍历过程会往queue里加元素
            int size = queue.size();
            // 是否结束了
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(end && poll.left != null) {
                    return false;
                }
                if(poll.left != null) {
                    queue.offer(poll.left);
                } else {
                    end = true;
                }
                if(end && poll.right != null) {
                    return false;
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                } else {
                    end = true;
                }
            }
        }
        return true;
    }
}
