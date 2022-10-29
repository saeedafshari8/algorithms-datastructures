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

    @Override
    public void swap(T value1, T value2) {
        if (root == null) throw new IllegalStateException("Tree is null");
        if (root.getValue() == value1 || root.getValue() == value2)
            throw new IllegalStateException("Swapping root node is not possible");
        BinaryTreeNode<T> parentNode1 = getParent(value1);
        BinaryTreeNode<T> parentNode2 = getParent(value2);
        BinaryTreeNode<T> node1ToSwap;
        BinaryTreeNode<T> node2ToSwap;

        boolean isNode1LeftChild = false;
        if (parentNode1.left.getValue() == value1) {
            node1ToSwap = parentNode1.left;
            isNode1LeftChild = true;
        } else node1ToSwap = parentNode1.right;

        if (node1ToSwap == null) throw new IllegalStateException("Node not found");

        boolean isNode2LeftChild = false;
        if (parentNode2.left.getValue() == value2) {
            node2ToSwap = parentNode2.left;
            isNode2LeftChild = true;
        } else node2ToSwap = parentNode2.right;

        if (node2ToSwap == null) throw new IllegalStateException("Node not found");

        if (node1ToSwap == node2ToSwap) return;

        if (isNode1LeftChild) {
            parentNode1.left = node2ToSwap;
        } else {
            parentNode1.right = node2ToSwap;
        }

        if (isNode2LeftChild) {
            parentNode2.left = node1ToSwap;
        } else {
            parentNode2.right = node1ToSwap;
        }
    }

    private BinaryTreeNode<T> getParent(T value) {
        BinaryTreeNode<T> parent = getParentRecursive(null, root, value);
        if (parent == null && root.getValue() != value)
            throw new IllegalStateException("Node not found");
        return parent;
    }

    private BinaryTreeNode<T> getParentRecursive(BinaryTreeNode<T> parentNode, BinaryTreeNode<T> node, T value) {
        if (node.getValue() == value) return parentNode;
        if (node.left != null) {
            if (node.left.getValue() == value) return node;
            BinaryTreeNode<T> parent = getParentRecursive(node, node.left, value);
            if (parent != null) return parent;
        }
        if (node.right != null) {
            if (node.right.getValue() == value) return node;
            return getParentRecursive(node, node.right, value);
        }
        return null;
    }

    @Override
    public List<T> getPathTo(T value) {
        if (root == null) throw new IllegalStateException("Root node cannot be null");
        return root.getPathTo(value);
    }

    @Override
    public List<T> getLeaves() {
        if (root == null) throw new IllegalStateException("Root node cannot be null");
        return root.getLeaves();
    }

    @Override
    public List<List<T>> getAllPathsToLeaves() {
        if (root == null) throw new IllegalStateException("Root node cannot be null");
        return root.getAllPathsToLeaves();
    }

    public static <T extends Comparable<T>> BinaryTree<T> from(T[] sortedArray) {
        if (sortedArray.length == 0) return new SimpleBinaryTree<>();
        BinaryTreeNode<T> node = new BinaryTreeNode<T>().parseBalancedTree(sortedArray);
        return new SimpleBinaryTree<>(node);
    }
}
