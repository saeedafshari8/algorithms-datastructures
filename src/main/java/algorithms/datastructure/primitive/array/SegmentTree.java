package algorithms.datastructure.primitive.array;

public class SegmentTree {

    public static int[] sumSegmentTree(int[] input) {
        int[] segmentTree = new int[input.length * 2 + 1];
        sumSegmentTreeRecursive(0, 0, input.length - 1, segmentTree, input);
        return segmentTree;
    }

    private static int sumSegmentTreeRecursive(int segmentTreeIndex, int start, int end, int[] segmentTree, int[] input) {
        if (start == end) {
            segmentTree[segmentTreeIndex] = input[start];
            return input[start];
        }
        int mid = (start + end) / 2;
        int leftSum = sumSegmentTreeRecursive(2 * segmentTreeIndex + 1, start, mid, segmentTree, input);
        int rightSum = sumSegmentTreeRecursive(2 * segmentTreeIndex + 2, mid + 1, end, segmentTree, input);
        segmentTree[segmentTreeIndex] = leftSum + rightSum;
        return segmentTree[segmentTreeIndex];
    }

    public static int getSum(int[] segmentTree, int start, int end) {
        return getSumRecursive(0, 0, segmentTree.length - 1, start, end, segmentTree);
    }

    private static int getSumRecursive(int segmentTreeIndex, int start, int end, int rangeStart, int rangeEnd, int[] segmentTree) {
        if (rangeStart <= start && rangeEnd >= end) {
            return segmentTree[segmentTreeIndex];
        }
        if (end < start || start > rangeEnd) {
            return 0;
        }
        int mid = (start + end) / 2;
        int leftSum = getSumRecursive(2 * segmentTreeIndex + 1, start, mid, rangeStart, rangeEnd, segmentTree);
        int rightSum = getSumRecursive(2 * segmentTreeIndex + 2, mid + 1, end, rangeStart, rangeEnd, segmentTree);
        return leftSum + rightSum;
    }

    public static int[] maxSegmentTree(int[] input) {
        int[] segmentTree = new int[input.length * 2 + 1];
        maxSegmentTreeRecursive(0, 0, input.length - 1, segmentTree, input);
        return segmentTree;
    }

    private static int maxSegmentTreeRecursive(int segmentTreeIndex, int start, int end, int[] segmentTree, int[] input) {
        if (start == end) {
            segmentTree[segmentTreeIndex] = input[start];
            return input[start];
        }
        int mid = (start + end) / 2;
        int leftMax = maxSegmentTreeRecursive(2 * segmentTreeIndex + 1, start, mid, segmentTree, input);
        int rightMax = maxSegmentTreeRecursive(2 * segmentTreeIndex + 2, mid + 1, end, segmentTree, input);
        segmentTree[segmentTreeIndex] = Integer.max(leftMax, rightMax);
        return segmentTree[segmentTreeIndex];
    }

//    int[] createMaxSegmentTree(int input) {
//
//    }
}
