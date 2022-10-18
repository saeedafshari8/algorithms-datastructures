package algorithms.datastructure.binarytree;

import java.util.*;

public class SimpleBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    public BinaryTreeNode<T> root;

    SimpleBinaryTree() {
    }

    SimpleBinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public void insert(T value) {
        if (this.root == null) this.root = new BinaryTreeNode<>(value);
        else root.insert(value);
    }

    @Override
    public boolean contains(T value) {
        if (this.root == null) return false;
        return root.contains(value);
    }

    @Override
    public List<T> preOrder() {
        if (root == null) return Collections.emptyList();
        return root.preOrder();
    }

    @Override
    public List<T> inOrder() {
        if (root == null) return Collections.emptyList();
        return root.inOrder();
    }

    @Override
    public List<T> postOrder() {
        if (root == null) return Collections.emptyList();
        return root.postOrder();
    }

    @Override
    public void remove(T value) {
        if (root == null) return;
        if (root.getValue() == value) root = null;
        else root.remove(value);
    }

    @Override
    public int[] toOriginalArrayList(List<Integer> preOrderTraverse) {
        if (root == null) return new int[0];
        int numberOfNodes = preOrderTraverse.size();
        int[] result = new int[preOrderTraverse.size()];
        toOriginalArrayRecursive(result, preOrderTraverse, 0, numberOfNodes - 1, 0);
        return result;
    }

    private int toOriginalArrayRecursive(int[] result, List<Integer> preOrderTraverse, int start, int end, int index) {
        if (start > end) return index;

        int mid = (start + end) / 2;
        result[mid] = preOrderTraverse.get(index);
        index++;
        index = toOriginalArrayRecursive(result, preOrderTraverse, start, mid - 1, index);
        index = toOriginalArrayRecursive(result, preOrderTraverse, mid + 1, end, index);
        return index;
    }

    @Override
    public List<T> leftView() {
        if (root == null) return Collections.emptyList();
        List<T> result = new ArrayList<>();
        leftViewRecursive(this.root, result, 0, 1);
        return result;
    }

    private int leftViewRecursive(BinaryTreeNode<T> node, List<T> result, int maxHeight, int height) {
        if (node == null) {
            return maxHeight;
        }
        if (height > maxHeight) {
            result.add(node.getValue());
            maxHeight = height;
        }
        maxHeight = leftViewRecursive(node.left, result, maxHeight, height + 1);
        maxHeight = leftViewRecursive(node.right, result, maxHeight, height + 1);
        return maxHeight;
    }

    @Override
    public List<T> rightView() {
        if (root == null) return Collections.emptyList();
        List<T> result = new ArrayList<>();
        rightViewRecursive(this.root, result, 0, 1);
        return result;
    }

    private int rightViewRecursive(BinaryTreeNode<T> node, List<T> result, int maxHeight, int height) {
        if (node == null) {
            return maxHeight;
        }
        if (height > maxHeight) {
            result.add(node.getValue());
            maxHeight = height;
        }
        maxHeight = leftViewRecursive(node.right, result, maxHeight, height + 1);
        maxHeight = leftViewRecursive(node.left, result, maxHeight, height + 1);
        return maxHeight;
    }

    @Override
    public int height() {
        if (root == null) return 0;
        return heightRecursive(root, 1, 1);
    }

    @Override
    public List<T> nodesAtLevel(int level) {
        int height = height();
        if ((root == null && level > 0) || height < level)
            throw new IllegalStateException(String.format("The level should be less than or equals with the height of the tree.[Height=%d]", height));
        List<T> result = new ArrayList<>();
        nodesAtLevelRecursive(root, result, 1, level);
        return result;
    }

    private void nodesAtLevelRecursive(BinaryTreeNode<T> node, List<T> result, int currentLevel, int targetLevel) {
        if (node == null || currentLevel > targetLevel) return;
        if (currentLevel == targetLevel) {
            result.add(node.getValue());
        }
        nodesAtLevelRecursive(node.left, result, currentLevel + 1, targetLevel);
        nodesAtLevelRecursive(node.right, result, currentLevel + 1, targetLevel);
    }

    private int heightRecursive(BinaryTreeNode<T> node, int maxHeight, int height) {
        if (height > maxHeight) {
            maxHeight = height;
        }
        if (node.left != null) {
            maxHeight = heightRecursive(node.left, maxHeight, height + 1);
        }
        if (node.right != null) {
            maxHeight = heightRecursive(node.right, maxHeight, height + 1);
        }
        return maxHeight;
    }

    public static <T extends Comparable<T>> BinaryTree<T> from(T[] sortedArray) {
        if (sortedArray.length == 0) return new SimpleBinaryTree<>();
        BinaryTreeNode<T> node = new BinaryTreeNode<T>().parseBalancedTree(sortedArray);
        return new SimpleBinaryTree<>(node);
    }
}
