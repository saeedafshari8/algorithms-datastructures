package algorithms.datastructure.primitive.array;

public class MergeSort {

    public static void sort(int[] numbers) {
        sortRecursive(0, numbers.length - 1, numbers);
    }

    private static void sortRecursive(int start, int end, int[] numbers) {
        if (start >= end) return;
        int mid = (end + start) / 2;

        sortRecursive(start, mid, numbers);
        sortRecursive(mid + 1, end, numbers);
        merge(start, mid, end, numbers);
    }

    private static void merge(int start, int mid, int end, int[] numbers) {
        int i = start;
        int j = mid + 1;
        int index = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (numbers[i] <= numbers[j]) {
                tmp[index] = numbers[i];
                i++;
            } else {
                tmp[index] = numbers[j];
                j++;
            }
            index++;
        }
        while (i <= mid) {
            tmp[index] = numbers[i];
            index++;
            i++;
        }
        while (j <= end) {
            tmp[index] = numbers[j];
            index++;
            j++;
        }
        index = 0;
        for (int k = start; k <= end; k++) {
            numbers[k] = tmp[index];
            index++;
        }
    }
}
