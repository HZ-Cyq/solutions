package nowcoder.code.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/20
 */
public class Bm26Solution {
    public static void main(String[] args) {
        Bm26Solution bm26Solution = new Bm26Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        ArrayList<ArrayList<Integer>> arrayLists = bm26Solution.levelOrder(treeNode1);
        System.out.println(arrayLists);
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        if(root == null) {
            return re;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // 上一层最后一个结点
        TreeNode lastLevelEndNode = root;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            // !! 注意这里的curLevelEndNode在外层。
            TreeNode curLevelEndNode = null;
            // 迭代之后，会将queue当前层所有元素出队，排到list中
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null) {
                    queue.offer(poll.left);
                    curLevelEndNode = poll.left;
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                    curLevelEndNode = poll.right;
                }
                if(poll == lastLevelEndNode) {
                    lastLevelEndNode = curLevelEndNode;
                    break;
                }
            }
            re.add(list);
        }
        return re;
    }

}
