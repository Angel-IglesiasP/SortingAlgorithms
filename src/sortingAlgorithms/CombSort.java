package sortingAlgorithms;

import shapes.Shape;
import utilities.ShapeComparison;

public class CombSort {
	/**
	 * Sorts inplace using the selected comparison (h, a, v).
	 * @param arr array to sort 
	 * @param t comparison mode
	 */
	public static void combSort(Shape[] arr, char t ) {
		int n = arr.length;
		int gap = n;
		final double SHRINK = 1.3;
		boolean swapped = true;
		while (gap > 1 || swapped) {
			gap = (int) (gap / SHRINK);
			if (gap < 1) gap = 1;
			swapped = false;
			for (int i = 0; i + gap < n; i++) {
				if (ShapeComparison.compare(arr[i], arr[i + gap], t) > 0) {
					Shape temp = arr[i];
					arr[i] = arr[i + gap];
					arr[i + gap] = temp;
					swapped = true;
				}
			}
		}
	}
}
