package com.lhz.Algorithm.BinarySearchTree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lhz
 * @version 1.0
 * @date 2020/7/25 15:06
 * 二分搜索树
 */
//Key因为Key要进行比较，所以要继承Comparable
public class BST<Key extends Comparable<Key>, Value> {
    //节点
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root;  //根节点
    private int count;  //树节点的个数

    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    public Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);
        } else if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else {
            node.left = insert(node.left, key, value);
        }
        return node;
    }

    //查询二叉搜索树中是否包含某个值
    public boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }

        if (node.key.compareTo(key) > 0) {
            return contain(node.left, key);
        } else if (node.key.compareTo(key) == 0) {
            return true;
        } else {
            return contain(node.right, key);
        }
    }

    public boolean coutain(Key key) {
        return contain(root, key);
    }


    //查询二叉平衡树key的value
    public Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }

        if (node.key.compareTo(key) > 0) {
            return search(node.left, key);
        } else if (node.key.compareTo(key) == 0) {
            return node.value;
        } else {
            return search(node.right, key);
        }
    }

    public Value search(Key key) {
        return search(root, key);
    }

    //前序遍历
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    //中序遍历
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    //后续遍历
    public void afterOrder(Node node) {
        if (node != null) {
            afterOrder(node.left);
            afterOrder(node.right);
            System.out.println(node.key);
        }
    }

    public void afterOrder() {
        afterOrder(root);
    }

    //层序遍历，广度优先
    public void levelOrder() {
        //用linkedlist实现一个队列
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.key);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //查询一个二叉搜索树的最小值
    public Node minNum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //递归实现
//    public Node minNum(Node node){
//        if(node.left==null){
//            return node;
//        }
//        return minNum(node.left);
//    }

    public Key minNum() {
        assert count != 0;
        return minNum(root).key;
    }

    //查询一个二叉搜索树的最大键值所在的节点
    public Node maxNum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Key maxNum() {
        assert count != 0;
        Node node = maxNum(root);
        return node.key;
    }

    //删除最小值的节点
    public void removeMin() {
        if (root != null) {
            removeMin(root);
        }
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    public Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    public Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void removeMax() {
        if (root != null) {
            removeMax(root);
        }
    }


    public Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            //当左子树或者左右子树都不存在
            if(node.left==null){
                Node rightNode = node.right;
                node.right = null;
                count --;
                return rightNode;
            }

            //当右子树不存在
            if(node.right==null){
                Node leftNode = node.left;
                node.left = null;
                count --;
                return leftNode;
            }

            //当左右子树都存在的情况下
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = new Node(minNum(node.right));
            count++;
            successor.left = node.left;
            successor.right = removeMin(node.right);

            //找到比待删除节点大的节点，也可以是节点左子树的最大节点
            //用这个节点顶替待删除节点的位置
//            Node successor = new Node(maxNum(node.left));
//            count ++;
//            successor.right = node.right;
//            successor.left = removeMax(node.left);
            node.left = null;
            node.right = null;
            count --;
            return successor;
        }
    }

    public void remove(Key key) {
    }


    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<Integer, String>();
        Integer[] arr = new Integer[]{5, 78, 3, 46, 37};
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i], arr[i].toString());
        }
        bst.removeMax();
        bst.inOrder();
//        bst.levelOrder();
    }
}
