package algorithms.datastructure.binarytree;

import java.util.List;

public interface BinaryTree<T extends Comparable<T>> {
    void insert(T value);

    boolean contains(T value);

    List<T> preOrder();

    List<T> inOrder();

    List<T> postOrder();

    void remove(T value);
}
