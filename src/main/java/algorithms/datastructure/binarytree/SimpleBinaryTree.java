package algorithms.datastructure.binarytree;

import java.util.Collections;
import java.util.List;

public class SimpleBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    public BinaryTreeNode<T> root;

    SimpleBinaryTree() {
    }

    SimpleBinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public void insert(T value) {
        if (this.root == null) createRoot(value);
        else root.insert(value);
    }

    @Override
    public boolean contains(T value) {
        if (this.root == null) return false;
        return root.contains(value);
    }

    public static <T extends Comparable<T>> BinaryTree<T> from(T[] sortedArray) {
        if (sortedArray.length == 0) return new SimpleBinaryTree<>();
        BinaryTreeNode<T> node = new BinaryTreeNode<T>().parseBalancedTree(sortedArray);
        return new SimpleBinaryTree<>(node);
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

    private void createRoot(T value) {
        this.root = new BinaryTreeNode<>(value);
    }
}
