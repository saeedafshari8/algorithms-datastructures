package algorithms.classic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

    @Test
    void getMinimumChangesReturnCorrectValue() {
        int target = 15;
        int[] coins = new int[]{1, 3, 5, 7};

        int minimumChanges = CoinChange.getMinimumChanges(coins, target);

        assertEquals(3, minimumChanges);
    }

    @Test
    void getMinimumChangesReturnMinusOneWhenTheChangeIsNotPossible() {
        int target = 15;
        int[] coins = new int[]{6, 7, 8};

        int minimumChanges = CoinChange.getMinimumChanges(coins, target);

        assertEquals(-1, minimumChanges);
    }
}
