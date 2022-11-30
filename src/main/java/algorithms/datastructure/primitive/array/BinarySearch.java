package algorithms.datastructure.primitive.array;

public class BinarySearch {

    public int search(int[] items, int item){
        int left = 0;
        int right = items.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(items[mid] == item){
                return mid;
            } else if(items[mid] < item){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return left;
    }
}
