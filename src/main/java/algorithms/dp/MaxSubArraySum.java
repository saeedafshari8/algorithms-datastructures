package algorithms.dp;

/**
 * https://leetcode.com/problems/maximum-subarray
 */
public class MaxSubArraySum {

    public static int getMaxSubArraySum(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Integer.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
