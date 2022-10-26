package algorithms.datastructure.primitive.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrappingRainWaterTest {

    @Test
    void trapReturnsCorrectVolume() {
        int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        int actual = trappingRainWater.trap(heights);

        assertEquals(6, actual);
    }

    @Test
    void trapReturnsCorrectVolume2() {
        int[] heights = new int[]{4, 2, 0, 3, 2, 5};
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        int actual = trappingRainWater.trap(heights);

        assertEquals(9, actual);
    }
}
