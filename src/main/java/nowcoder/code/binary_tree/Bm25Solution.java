package nowcoder.code.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenyuqun@zlongame.com
 * @date 2023/9/20
 */
public class Bm25Solution {

    public static void main(String[] args) {
        Bm25Solution solution = new Bm25Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode2.right = treeNode3;

        int[] ints = solution.postorderTraversal2(treeNode1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /****************************************/
    // 递归
    public int[] postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        postorderTraver(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void postorderTraver(TreeNode node, List<Integer> list) {
        if (node == null)  {
            return;
        }
        postorderTraver(node.left, list);
        postorderTraver(node.right, list);
        list.add(node.val);
    }
    /****************************************/

    // 迭代
    public int[] postorderTraversal2(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        // 每次迭代后的效果
        // temp值为空：打印一个元素，将该元素的右兄弟结点入栈
        // temp值不为空：将temp到其最左孩子结点都入栈,将temp设置成该结点的右兄弟结点
        while (temp != null || !stack.isEmpty()) {
            if(temp == null) {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                if(!stack.isEmpty()) {
                    TreeNode peek = stack.peek();
                    if(peek.left == pop) {
                        temp = peek.right;
                    }
                }
            } else {
                stack.push(temp);
                while (temp.left != null) {
                    stack.push(temp.left);
                    temp = temp.left;
                }
                temp = temp.right;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /****************************************/
    // 官网提供的迭代
    public class Solution {
        public int[] postorderTraversal (TreeNode root) {
            //添加遍历结果的数组
            List<Integer> list = new ArrayList();
            Stack<TreeNode> s = new Stack<TreeNode>();
            TreeNode pre = null;
            while(root != null || !s.isEmpty()){
                //每次先找到最左边的节点
                while(root != null){
                    s.push(root);
                    root = root.left;
                }
                //弹出栈顶
                TreeNode node = s.pop();
                //如果该元素的右边没有或是已经访问过
                if(node.right == null || node.right == pre){
                    //访问中间的节点
                    list.add(node.val);
                    //且记录为访问过了
                    pre = node;
                }else{
                    //该节点入栈
                    s.push(node);
                    //先访问右边
                    root = node.right;
                }
            }
            //返回的结果
            int[] res = new int[list.size()];
            for(int i = 0; i < list.size(); i++)
                res[i] = list.get(i);
            return res;
        }
    }


}
