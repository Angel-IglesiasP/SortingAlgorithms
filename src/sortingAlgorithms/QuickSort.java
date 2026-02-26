package sortingAlgorithms;

import shapes.Shape;
import utilities.ShapeComparison;

public class QuickSort
{
	public static void quickSort(Shape[] arr, char t)
	{
		quickSort(arr, 0, arr.length - 1, t);
	}
	
	private static void quickSort(Shape[] arr, int low, int high, char t)
	{
		if (low < high)
		{
			int pivotIndex = partition(arr, low, high, t);
			quickSort(arr, low, pivotIndex - 1, t);
			quickSort(arr, pivotIndex + 1, high, t);
		}
	}
	
	private static int partition(Shape[] arr, int low, int high, char t)
	{
		Shape pivot = arr[high];
		
		int i = low - 1;
		
		for (int j = low; j< high; j++)
		{
			if (ShapeComparison.compare(arr[j], pivot, t) < 0)
            {
                i++; 

                swap(arr, i, j);
            }
		}
		
		swap(arr, i + 1, high);
		return i+ 1;
	}
	
	private static void swap(Shape[] arr, int i, int j)
    {
        Shape temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
