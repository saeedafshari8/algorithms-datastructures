package algorithms.datastructure.primitive.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {

    @Test
    void sortWorksAsExpected() {
        int[] numbers = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        MergeSort.sort(numbers);

        String actual = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String expected = "1,2,3,4,5,6,7,8,9";
        assertEquals(expected, actual);
    }

    @Test
    void sortWorksAsExpectedForEvenNumberOfNumbers() {
        int[] numbers = new int[]{9, 8, 7, 6, 5, 4, 3, 2};

        MergeSort.sort(numbers);

        String actual = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String expected = "2,3,4,5,6,7,8,9";
        assertEquals(expected, actual);
    }
}
