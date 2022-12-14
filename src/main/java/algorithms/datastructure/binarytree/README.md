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

    void swap(T value1, T value2);

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

    void swap(T value1, T value2);

    List<T> getPathTo(T value);

    List<T> getLeaves();

    List<List<T>> getAllPathsToLeaves();

    int getMaxPathSum(BinaryTreeNode<Integer> root);
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

## void swap(T value1, T value2)

Swaps two nodes in a binary tree

## List<T> getPathTo(T value)

Returns the path to a node

## List<T> getLeaves()

Returns a tree leaves

## List<List<T>> getAllPathsToLeaves() getAllPathsToLeaves()

Returns a List of path from root node to all leaves

## int getMaxPathSum(BinaryTreeNode<Integer> root)

Calculate the maximum path sum

## public static <T extends Comparable<T>> BinaryTree<T> from(T[] sortedArray)

To create a balanced tree out of a sorted array

## public static <T extends Comparable<T>> BinaryTree<T> createBinaryTreeFromPreOrderAndInOrder(List<T> preOrder, List<T> inOrder)

To create a tree from pre-order and in-order traversals
