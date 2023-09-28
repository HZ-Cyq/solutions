package nowcoder.code.binary_tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/20
 */
public class Bm27Solution {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        // write code here
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        if(pRoot == null) {
            return re;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(pRoot);
        // 当前的层级，偶数从左到右打印，奇数从右到左打印
        int curLevel = 0;
        TreeNode lastLevelEndNode = pRoot;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            TreeNode curLevelEndNode = null;
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
                    // 当了该层的最后一个结点，说明该层遍历完了，退出
                    // 除了最后一层，其他层的循环都是从这里跳出的，所以遍历一层的时候可能要经历多次while循环
                    lastLevelEndNode = curLevelEndNode;
                    break;
                }
            }
            if(curLevel % 2 != 0) {
                Collections.reverse(list);
            }
            curLevel++;
            re.add(list);
        }
        return re;
    }
}
