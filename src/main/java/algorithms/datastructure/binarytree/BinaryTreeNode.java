package algorithms.datastructure.binarytree;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeNode<T extends Comparable<T>> {

    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    @Getter
    private T value;

    BinaryTreeNode(T value) {
        this.value = value;
    }

    BinaryTreeNode() {
    }

    void insert(T newValue) {
        if (value.compareTo(newValue) > 0) {
            if (left == null) {
                left = new BinaryTreeNode<>(newValue);
            } else {
                left.insert(newValue);
            }
        } else {
            if (right == null) {
                right = new BinaryTreeNode<>(newValue);
            } else {
                right.insert(newValue);
            }
        }
    }

    boolean contains(T newValue) {
        if (value.compareTo(newValue) == 0) {
            return true;
        } else if (value.compareTo(newValue) > 0) {
            if (left == null) {
                return false;
            } else {
                return left.contains(newValue);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(newValue);
            }
        }
    }

    BinaryTreeNode<T> parseBalancedTree(T[] sortedArray) {
        return toBalancedTree(sortedArray, 0, sortedArray.length - 1);
    }

    private BinaryTreeNode<T> toBalancedTree(T[] sortedArray, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        BinaryTreeNode<T> node = new BinaryTreeNode<>(sortedArray[mid]);
        node.left = toBalancedTree(sortedArray, start, mid - 1);
        node.right = toBalancedTree(sortedArray, mid + 1, end);
        return node;
    }

    List<T> preOrder() {
        List<T> result = new ArrayList<>();
        preOrderRecursive(result);
        return result;
    }

    void preOrderRecursive(List<T> result) {
        result.add(value);
        if (left != null) {
            left.preOrderRecursive(result);
        }
        if (right != null) {
            right.preOrderRecursive(result);
        }
    }

    List<T> inOrder() {
        List<T> result = new ArrayList<>();
        inOrderRecursive(result);
        return result;
    }

    private void inOrderRecursive(List<T> result) {
        if (left != null) {
            left.inOrderRecursive(result);
        }
        result.add(value);
        if (right != null) {
            right.inOrderRecursive(result);
        }
    }

    List<T> postOrder() {
        List<T> result = new ArrayList<>();
        postOrderRecursive(result);
        return result;
    }

    private void postOrderRecursive(List<T> result) {
        if (left != null) {
            left.postOrderRecursive(result);
        }
        if (right != null) {
            right.postOrderRecursive(result);
        }
        result.add(value);
    }

    void remove(T value) {
        if (this.left != null && this.left.value.compareTo(value) == 0) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.value.compareTo(value) == 0) {
            this.right = null;
            return;
        }
        if (this.value.compareTo(value) > 0) {
            if (this.left == null) return;
            this.left.remove(value);
        } else {
            if (this.right == null) return;
            this.right.remove(value);
        }
    }
}
