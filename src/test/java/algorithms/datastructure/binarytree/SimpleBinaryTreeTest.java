package algorithms.datastructure.binarytree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleBinaryTreeTest {

    @Test
    void parseBalancedTreeWorksCorrectlyPreOrderEvenNumbers() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};

        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        List<Integer> result = simpleBinaryTree.preOrder();
        String actual = arrayToString(result);
        assertEquals("3,1,2,5,4,6", actual);
    }

    @Test
    void parseBalancedTreeWorksCorrectlyPreOrderOddNumbers() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        List<Integer> result = simpleBinaryTree.preOrder();

        String actual = arrayToString(result);
        assertEquals("3,1,2,4,5", actual);
    }

    @Test
    void parseBalancedTreeWorksCorrectlyPostOrder() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        List<Integer> result = simpleBinaryTree.postOrder();

        String actual = arrayToString(result);
        assertEquals("2,1,4,6,5,3", actual);
    }

    @Test
    void parseBalancedTreeWorksCorrectlyInOrder() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        List<Integer> result = simpleBinaryTree.inOrder();

        String actual = arrayToString(result);
        assertEquals("1,2,3,4,5,6", actual);
    }

    @Test
    void insertWorksCorrectlyInOrder() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);
        simpleBinaryTree.insert(7);

        List<Integer> result = simpleBinaryTree.inOrder();
        String actual = arrayToString(result);
        assertEquals("1,2,3,4,5,6,7", actual);
    }

    @Test
    void containsWorksCorrectlyWhenValueIsAvailable() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        boolean actual = simpleBinaryTree.contains(6);

        assertTrue(actual);
    }


    @Test
    void containsWorksCorrectlyWhenValueIsMissing() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        boolean actual = simpleBinaryTree.contains(7);

        assertFalse(actual);
    }

    @Test
    void removeWorksCorrectlyWhenNodeIsAvailable() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        simpleBinaryTree.remove(3);

        assertEquals(Collections.emptyList(), simpleBinaryTree.preOrder());
    }

    @Test
    void removeWorksCorrectlyWhenNodeIsMissing() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        simpleBinaryTree.remove(6);

        assertEquals(List.of(3, 1, 2, 4, 5), simpleBinaryTree.preOrder());
    }

    @Test
    void removeWorksCorrectlyWhenRooIsNotAvailable() {
        Integer[] sortedArray = new Integer[0];
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        simpleBinaryTree.remove(3);

        assertEquals(Collections.emptyList(), simpleBinaryTree.preOrder());
    }

    @Test
    void toOriginalArrayReturnsCorrectResult() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(array);

        String actual = Arrays.stream(simpleBinaryTree.toOriginalArrayList(simpleBinaryTree.preOrder())).filter(Objects::nonNull).mapToObj(String::valueOf).collect(Collectors.joining(","));

        var expected = "1,2,3,4,5";
        assertEquals(expected, actual);
    }

    @Test
    void leftViewReturnsCorrectList() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(array);

        String actual = simpleBinaryTree.leftView().stream().map(String::valueOf).collect(Collectors.joining(","));

        var expected = "3,1,2";
        assertEquals(expected, actual);
    }

    @Test
    void rightViewReturnsCorrectList() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(array);

        String actual = simpleBinaryTree.rightView().stream().map(String::valueOf).collect(Collectors.joining(","));

        var expected = "3,4,5";
        assertEquals(expected, actual);
    }

    @Test
    void heightReturnsCorrectValue() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        int height = simpleBinaryTree.height();

        assertEquals(3, height);
    }

    @Test
    void heightReturnsCorrectValue2() {
        Integer[] sortedArray = new Integer[]{1, 2, 3};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        int height = simpleBinaryTree.height();

        assertEquals(2, height);
    }

    @Test
    void heightReturnsCorrectValueWhenTreeIsEmpty() {
        Integer[] sortedArray = new Integer[0];
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        int height = simpleBinaryTree.height();

        assertEquals(0, height);
    }

    @Test
    void nodesAtLevelReturnsCorrectList() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        String actual = simpleBinaryTree.nodesAtLevel(2).stream().map(String::valueOf).collect(Collectors.joining(","));

        assertEquals("1,4", actual);
    }

    @Test
    void nodesAtLevelThrowsWhenLevelIsHigherThanTheHeightOfTree() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> simpleBinaryTree.nodesAtLevel(4));

        assertEquals("The level should be less than or equals with the height of the tree.[Height=3]", exception.getMessage());
    }

    @Test
    void swapWorksCorrectlyWhenNodesAreAvailable() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        simpleBinaryTree.swap(1, 4);

        String actual = arrayToString(simpleBinaryTree.preOrder());
        String expected = "3,4,5,1,2";
        assertEquals(actual, expected);
    }

    @Test
    void swapWorksCorrectlyWhenNodesAreTheSame() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        simpleBinaryTree.swap(1, 1);

        String actual = arrayToString(simpleBinaryTree.preOrder());
        String expected = "3,1,2,4,5";
        assertEquals(actual, expected);
    }

    @Test
    void swapThrowsWhenTryingToSwapRootNode() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> simpleBinaryTree.swap(3, 1));

        assertEquals("Swapping root node is not possible", exception.getMessage());
    }

    @Test
    void swapThrowsWhenNodeIsMissing() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> simpleBinaryTree.swap(1, 8));

        assertEquals("Node not found", exception.getMessage());
    }

    @Test
    void getPathToReturnsCorrectListWhenNodeIsAvailable() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        List<Integer> path = simpleBinaryTree.getPathTo(4);

        String actual = arrayToString(path);
        String expected = "3,4";
        assertEquals(expected, actual);
    }

    @Test
    void getPathToReturnsCorrectListWhenNodeIsAvailable2() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        List<Integer> path = simpleBinaryTree.getPathTo(4);

        String actual = arrayToString(path);
        String expected = "3,5,4";
        assertEquals(expected, actual);
    }

    @Test
    void getLeavesReturnsCorrectList() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        List<Integer> path = simpleBinaryTree.getLeaves();

        String actual = arrayToString(path);
        String expected = "2,4,6";
        assertEquals(expected, actual);
    }

    @Test
    void getAllPathsToLeavesReturnsCorrectList() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6};
        BinaryTree<Integer> simpleBinaryTree = SimpleBinaryTree.from(sortedArray);

        List<List<Integer>> paths = simpleBinaryTree.getAllPathsToLeaves();

        int i = 0;
        for (List<Integer> path : paths) {
            String actual = arrayToString(path);
            String expected = switch (i) {
                case 0 -> "3,1,2";
                case 1 -> "3,5,4";
                case 2 -> "3,5,6";
                default -> "";
            };
            i++;
            assertEquals(expected, actual);
        }
    }

    @Test
    void getMaxPathSumReturnsCorrectResult() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(-2);
        root.right = new BinaryTreeNode<>(-3);
        root.left.left = new BinaryTreeNode<>(1);
        root.left.right = new BinaryTreeNode<>(3);
        root.right.left = new BinaryTreeNode<>(2);
        root.left.left.left = new BinaryTreeNode<>(-1);
        BinaryTree<Integer> simpleBinaryTree = new SimpleBinaryTree<>(root);

        int maxSum = simpleBinaryTree.getMaxPathSum(root);

        assertEquals(3, maxSum);
    }

    @Test
    void getMaxPathSumReturnsCorrectResult2() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(9);
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(-3);
        root.right.left = new BinaryTreeNode<>(-6);
        root.right.right = new BinaryTreeNode<>(2);
        root.right.right.left = new BinaryTreeNode<>(2);
        root.right.right.left.left = new BinaryTreeNode<>(-6);
        root.right.right.left.right = new BinaryTreeNode<>(-6);
        root.right.right.left.left.left = new BinaryTreeNode<>(-6);
        BinaryTree<Integer> simpleBinaryTree = new SimpleBinaryTree<>(root);

        int maxSum = simpleBinaryTree.getMaxPathSum(root);

        assertEquals(16, maxSum);
    }

    private static String arrayToString(List<Integer> result) {
        return String.join(",", result.stream().map(String::valueOf).toList());
    }
}

