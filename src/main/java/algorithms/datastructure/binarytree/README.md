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

    int[] toOriginalArrayList(List<Integer> preOrderTraverse);

    List<T> leftView();

    List<T> rightView();

    int height();

    List<T> nodesAtLevel(int level);
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

## int[] toOriginalArrayList(List<Integer> preOrderTraverse)

transforms a pre-order traverse of a balanced BST to the original sorted array

## List<T> leftView()

Return the left view of a binary tree

## List<T> rightView()

Return the right view of a binary tree

## int height()

Return the height of a tree

## List<T> nodesAtLevel(int level)

Returns nodes at the specified level of a tree

## public static <T extends Comparable<T>> BinaryTree<T> from(T[] sortedArray)

To create a balanced tree out of a sorted array
