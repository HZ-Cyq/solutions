package javabase.map.redblacktree;

import org.junit.Test;

import java.util.Random;
import java.util.TreeMap;

/**
 * 插入最多两次旋转，删除最多三次旋转，达到平衡
 * 最坏和平均时间复杂度都是O(N lnN)
 * 需要旋转的情况是父节点为红的时候。主要看叔叔节点：
 * 叔叔是红色：重新着色，红色上移，会导致父亲节点和爷爷节点都是红的情况，这时需要旋转。
 * 叔叔是黑色：新节点是父亲的左节点，右旋
 * 这里只实现了红黑树的put方法，没有实现remove方法
 *
 * @author chenyuqun
 * @date 2022/3/21 2:34 下午
 */
public class RedBlackTreeTest {
    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException {
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        RedBlackTree redBlackTree = new RedBlackTree();
        Random random = new Random(47);
        for (int j = 0; j < 1000; j++) {
            for (int i = 1; i <= 10000; i++) {
                int key = random.nextInt(100);
                treeMap.put(key, key);
                redBlackTree.put(key, key);
            }
            if(redBlackTree.equalWithTreeMap(treeMap)) {
                System.out.println("\n第" + (j + 1) + "个测试用例通过");
            } else {
                System.err.println("\n第" + (j + 1) + "个测试用例错误");
            }
            treeMap.clear();
            redBlackTree.clear();
        }
//        System.out.println("\ntreeMap:");
//        redBlackTree.printTreeMap(treeMap);
//        System.out.println("\nredBlackMap:");
//        redBlackTree.printRedBlackTree();
//        System.out.println("\nis equal:");
    }
}
