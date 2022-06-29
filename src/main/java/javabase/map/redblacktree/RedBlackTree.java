package javabase.map.redblacktree;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author chenyuqun
 * @date 2022/3/21 2:37 下午
 */
public class RedBlackTree {

    static boolean BLACK = true;

    static boolean RED = false;

    static class Node {
        int key;
        int val;
        Node left;
        Node right;
        Node parent;
        // 颜色：false:红色，true：黑色。
        boolean color = BLACK;

        // 默认的是红色的
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.color = RED;
        }
    }

    Node root;

    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (root == null) {
            root = node;
            root.color = BLACK;
            return;
        }
        Node p = root;
        // 新节点是父节点的哪个子节点？0代表父节点，1代表左节点，2代表右节点
        // 先插入进去，再平衡
        while (true) {
            if (key < p.key && p.left != null) {
                p = p.left;
                continue;
            }
            if (key > p.key && p.right != null) {
                p = p.right;
                continue;
            }
            if (key < p.key) {
                p.left = node;
                node.parent = p;
                break;
            }
            if (key > p.key) {
                p.right = node;
                node.parent = p;
                break;
            }
            p.val = val;
            break;
        }
            fixAfterInsertion(node);
    }

    public void clear() {
        this.root = null;
    }

    public void fixAfterInsertion(Node node) {
        int nodeType = getChildType(node);
        // 根节点不用调整
        if (nodeType == 0) {
            return;
        }
        Node parent = node.parent;
        // 父亲是黑色，不用继续调整
        if (parent.color == BLACK) {
            return;
        }
        Node grandFather = node.parent.parent;
        // 没有爷爷不用调整
        if (grandFather == null) {
            return;
        }
        // 叔叔是红色，重新着色
        int parentType = getChildType(parent);
        Node uncle = parentType == 1 ? node.parent.parent.right : node.parent.parent.left;
        if (uncle != null && uncle.color == RED) {
            uncle.color = BLACK;
            node.parent.color = BLACK;
            if (node.parent.parent.val != root.val) {
                // 红色上移了，爷爷和太爷爷可能有冲突，需要调整
                node.parent.parent.color = RED;
                fixAfterInsertion(node.parent.parent);
                return;
            }
            return;
        }
        // 叔叔不是红色，需要旋转
        // 爸爸是爷爷的右孩子，孩子是爸爸的左孩子。先对爸爸进行一次右旋
        Node root;
        if (parentType == 2) {
            if (nodeType == 1) {
                rightRotate(node.parent);
            }
            root = leftRotate(grandFather);
        } else {
            if (nodeType == 2) {
                leftRotate(node.parent);
            }
            root = rightRotate(grandFather);
        }
        root.color = BLACK;
        if (root.left != null) {
            root.left.color = RED;
        }
        if (root.right != null) {
            root.right.color = RED;
        }
    }


    /**
     * 左旋：右孩子当爸爸，输入的是旧的爸爸节节。返回的是新的爸爸节点
     *
     * @param node
     */
    public Node leftRotate(Node node) {
        if (node.right == null) {
            System.err.println("红黑树错误，对一个右孩子节点是空的节点左旋");
            return null;
        }
        int childType = getChildType(node);
        if (childType == -2) {
            System.err.println("红黑树错误，无法通过当前节点的父亲节点找到自己");
            return null;
        }
        Node newRoot = node.right;
        Node rootParent = node.parent;
        // 处理新的根节点的parent
        if (childType == 0) {
            this.root = newRoot;
        } else if (childType == 1) {
            rootParent.left = newRoot;
        } else if (childType == 2) {
            rootParent.right = newRoot;
        }

        node.right = newRoot.left;
        if (node.right != null) {
            node.right.parent = node;
        }
        node.parent = newRoot;

        newRoot.left = node;
        newRoot.parent = rootParent;
        return newRoot;
    }

    /**
     * 右旋：左孩子当爸爸，输入的是旧的爸爸节点，返回的是新的爸爸节点
     *
     * @param node
     */
    public Node rightRotate(Node node) {
        if (node.left == null) {
            System.err.println("红黑树错误，对一个左孩子节点是空的节点右旋");
            return null;
        }
        int childType = getChildType(node);
        if (childType == -2) {
            System.err.println("红黑树错误，无法通过当前节点的父亲节点找到自己");
            return null;
        }
        Node newRoot = node.left;
        Node rootParent = node.parent;
        // 处理新的根节点的parent
        if (childType == 0) {
            this.root = newRoot;
        } else if (childType == 1) {
            rootParent.left = newRoot;
        } else if (childType == 2) {
            rootParent.right = newRoot;
        }

        node.left = newRoot.right;
        if (node.left != null) {
            node.left.parent = node;
        }
        node.parent = newRoot;

        newRoot.right = node;
        newRoot.parent = rootParent;
        return newRoot;
    }

    /**
     * 是父亲节点的什么孩子
     * 返回值：0代表根节点，1代表左孩子，2代表右孩子，-1代表错误
     *
     * @return
     */
    public int getChildType(Node node) {
        if (node.parent == null) {
            return 0;
        }
        if (node == node.parent.left) {
            return 1;
        }
        if (node == node.parent.right) {
            return 2;
        }
        return -1;
    }


    /**
     * 判断该结构如TreeMap里的红黑书结构是否一样
     *
     * @param treeMap
     * @return
     */
    public boolean equalWithTreeMap(TreeMap<Integer, Integer> treeMap) throws NoSuchFieldException, IllegalAccessException {
        Class treeMapClass = TreeMap.class;
        Field rootField = treeMapClass.getDeclaredField("root");
        rootField.setAccessible(true);
        Object o = rootField.get(treeMap);
        Map.Entry<Integer, Integer> rootEntry = (Map.Entry<Integer, Integer>) o;
        return isEqual(root, rootEntry);
    }

    public void printTreeMap(TreeMap<Integer, Integer> treeMap) throws NoSuchFieldException, IllegalAccessException {
        Field rootField = treeMap.getClass().getDeclaredField("root");
        rootField.setAccessible(true);
        Object o = rootField.get(treeMap);
        Map.Entry<Integer, Integer> rootEntry = (Map.Entry<Integer, Integer>) o;
        printTreeMap0(rootEntry);
    }

    public void printTreeMap0(Map.Entry<Integer, Integer> entry) throws NoSuchFieldException, IllegalAccessException {
        if (entry == null) {
            System.out.print("null, ");
            return;
        }
        boolean color = (boolean) getDeclaredFieldVal(entry, "color");
        Map.Entry<Integer, Integer> parent = (Map.Entry<Integer, Integer>) getDeclaredFieldVal(entry, "parent");
        String parentStr = parent == null ? "null" : String.valueOf(parent.getKey());
        System.out.print("[" + entry.getValue() + ", " + color + ", " + parentStr + "]" + ", ");
        Map.Entry<Integer, Integer> left = (Map.Entry<Integer, Integer>) getDeclaredFieldVal(entry, "left");
        printTreeMap0(left);
        Map.Entry<Integer, Integer> right = (Map.Entry<Integer, Integer>) getDeclaredFieldVal(entry, "right");
        printTreeMap0(right);
    }

    public void printRedBlackTree() {
        printRedBlackTree0(root);
    }

    public void printRedBlackTree0(Node node) {
        if (node == null) {
            System.out.print("null, ");
            return;
        }
        String parentStr = node.parent == null ? "null" : String.valueOf(node.parent.key);
        System.out.print("[" + node.val + ", " + node.color + ", " + parentStr + "]" + ", ");
        printRedBlackTree0(node.left);
        printRedBlackTree0(node.right);
    }

    public boolean isEqual(Node node, Map.Entry<Integer, Integer> entry) throws NoSuchFieldException, IllegalAccessException {
        if (checkValEqual(node, entry)) {
            return false;
        }
        if (node == null && entry == null) {
            return true;
        }
        Map.Entry<Integer, Integer> parent = (Map.Entry<Integer, Integer>) getDeclaredFieldVal(entry, "parent");
        if (checkValEqual(Objects.requireNonNull(node).parent, parent)) {
            return false;
        }
        Map.Entry<Integer, Integer> left = (Map.Entry<Integer, Integer>) getDeclaredFieldVal(entry, "left");
        Map.Entry<Integer, Integer> right = (Map.Entry<Integer, Integer>) getDeclaredFieldVal(entry, "right");
        return isEqual(node.left, left) && isEqual(node.right, right);
    }

    public boolean checkValEqual(Node node, Map.Entry<Integer, Integer> entry) throws NoSuchFieldException, IllegalAccessException {
        if (node == null && entry == null) {
            return false;
        }
        if (node == null || entry == null) {
            return true;
        }
        if (node.key != entry.getKey()) {
            return true;
        }
        if (node.val != entry.getValue()) {
            return true;
        }
        boolean color = (boolean) getDeclaredFieldVal(entry, "color");
        return node.color != color;
    }

    public static Object getDeclaredFieldVal(Map.Entry entry, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = entry.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(entry);
    }
}
