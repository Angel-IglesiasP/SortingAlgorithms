package sortingAlgorithms;
import shapes.Shape;
import utilities.ShapeComparison;

public class SelectionSort {

	public static void selectionSort(Shape[] arr, char t) {
		
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++ ) { 
			
			int minIndex = i;
			
			for (int j = i + 1; j < n; j++) {
				
				if (ShapeComparison.compare(arr[j], arr[minIndex], t) < 0) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				Shape temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
}
