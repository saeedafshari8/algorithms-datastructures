package algorithms.datastructure.primitive.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeTest {

    @Test
    void sumSegmentTreeReturnCorrectSegmentTree() {
        int[] input = new int[]{1, 2, 5, 6, 7, 9};

        int[] segmentTree = SegmentTree.sumSegmentTree(input);

        String actual = Arrays.stream(segmentTree).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String expected = "30,8,22,3,5,13,9,1,2,0,0,6,7";
        assertEquals(expected, actual);
    }

    @Test
    void getSumReturnCorrectValue() {
        int[] input = new int[]{1, 2, 5, 6, 7, 9};

        int[] segmentTree = SegmentTree.sumSegmentTree(input);
        int fullRange = SegmentTree.getSum(segmentTree, 0, 5);
        int oneToThreeRange = SegmentTree.getSum(segmentTree, 1, 3);

        assertAll(
                () -> assertEquals(30, fullRange),
                () -> assertEquals(13, oneToThreeRange)
        );
    }

    @Test
    void maxSegmentTreeReturnCorrectSegmentTree() {
        int[] input = new int[]{1, 2, 5, 6, 7, 9};

        int[] segmentTree = SegmentTree.maxSegmentTree(input);

        String actual = Arrays.stream(segmentTree).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String expected = "9,5,9,2,5,7,9,1,2,0,0,6,7";
        assertEquals(expected, actual);
    }
}
