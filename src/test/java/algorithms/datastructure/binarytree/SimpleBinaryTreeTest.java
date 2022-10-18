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

    private static String arrayToString(List<Integer> result) {
        return String.join(",", result.stream().map(String::valueOf).toList());
    }
}
