package algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubArraySumTest {

    @Test
    void getMaxSubArraySumReturnsCorrectResult() {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int actual = MaxSubArraySum.getMaxSubArraySum(input);

        assertEquals(6, actual);
    }
}
