package algorithms.datastructure.primitive.array;

/*
https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int l = 0, r = height.length - 1, sum = 0, lMax = 0, rMax = 0;
        while (l <= r) {
            lMax = Math.max(height[l], lMax);
            rMax = Math.max(height[r], rMax);
            if (lMax < rMax) {
                sum += lMax - height[l];
                l++;
            } else {
                sum += rMax - height[r];
                r--;
            }
        }
        return sum;
    }
}
