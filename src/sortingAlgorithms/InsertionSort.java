package sortingAlgorithms;
import shapes.Shape;
import utilities.ShapeComparison;


public class InsertionSort {
	
	public static void insertionSort(Shape[] arr, char t) {
		
		int n = arr.length;
		for (int i = 1; i < n; i++ ) {
			
			Shape key = arr[i];
			int j = i - 1;
			
			while (j >= 0 && ShapeComparison.compare(arr[j], key, t) > 0) {
				arr[j +1] = arr[j];
				j--;
			}
			
			arr[j + 1] = key;
		}
	}

}
