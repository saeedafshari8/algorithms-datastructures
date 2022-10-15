#SimpleBinaryTree
A simple implementation of a binary tree with the following functionalities

```java
public interface BinaryTree<T extends Comparable<T>> {
    void insert(T value);

    boolean contains(T value);

    List<T> preOrder();

    List<T> inOrder();

    List<T> postOrder();

    void remove(T value);
}
```

## void insert(T value)

To insert a new value into the tree

## boolean contains(T value)

To check existence of a value in the tree

## List<T> preOrder()

Preorder traversal

## List<T> inOrder()

Inorder traversal

## List<T> postOrder()

Postorder traversal

## void remove(T value)

To remove a node from a tree

## public static <T extends Comparable<T>> BinaryTree<T> from(T[] sortedArray)

To create a balanced tree out of a sorted array
