package algorithms.classic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnapsackTest {

    @Test
    void getMaxValueReturnsCorrectValue() {
        int[] values = new int[]{3, 8, 4, 1, 5};
        int[] costs = new int[]{1, 5, 6, 2, 1};
        int targetCost = 10;

        int maxValue = Knapsack.getMaxValue(values, costs, targetCost);

        assertEquals(17, maxValue);
    }
}
