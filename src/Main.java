import java.util.Arrays;

/**
 * @author kurstan
 * @created at $DATE $TIME
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 1, 8, 200, 3, 9, 1};
        int[] sortedArray = insertionSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**BUBBLE SORT*/
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        while (length != 0) {
            int maxIndex = 0;
            for (int i = 1; i < length; i++) {
                if (array[i - 1] > array[i]) {
                    int low = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = low;
                    maxIndex = i;
                }
            }
            length = maxIndex;
        }
        return array;
    }

    /**SELECTION SORT*/
    public static int[] selectionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }

    /**INSERTION SORT*/
    public static int[] insertionSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int sorted = i - 1;
            while (sorted > -1 && array[sorted] > array[sorted + 1]) {
                int temp = array[sorted];
                array[sorted] = array[sorted + 1];
                array[sorted + 1] = temp;
                sorted--;
            }
        }
        return array;
    }

    /**QUICK SORT*/
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**BINARY SEARCH*/
    public static int binarySearch(int[] array, int num) {
        int jr = 0;
        int sr = array.length - 1;
        while (jr <= sr) {
            int mid = (jr + sr) / 2;
            if (array[mid] == num) {
                return mid;
            }
            if (array[mid] < num) {
                jr = mid + 1;
            } else {
                sr = mid - 1;
            }
        }
        return -1;
    }
}