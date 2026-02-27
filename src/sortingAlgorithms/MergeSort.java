package sortingAlgorithms;

import shapes.Shape;
import utilities.ShapeComparison;

public class MergeSort {
    /**
     * Sorts the entire array using the selected comparison.
     * @param arr array to sort
     * @param t comparison mode
     */
    public static void mergeSort(Shape[] arr, char t) {
        mergeSort(arr, 0, arr.length - 1, t);
    }

    /**
     * Sorts a subrange [low, high].
     * @param arr array
     * @param low inclusive start index
     * @param high inclusive end index
     * @param t comparison mode
     */
    private static void mergeSort(Shape[] arr, int low, int high, char t) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, t);
            mergeSort(arr, mid + 1, high, t);
            merge(arr, low, mid, high, t);
        }
    }

    /**
     * Merges two sorted subranges [low, mid] and [mid+1, high].
     * @param arr array
     * @param low start index
     * @param mid middle index
     * @param high end index
     * @param t comparison mode
     */
    private static void merge(Shape[] arr, int low, int mid, int high, char t) {
        Shape[] temp = new Shape[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (ShapeComparison.compare(arr[i], arr[j], t) < 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }
}
