package sortingAlgorithms;
import shapes.Shape;
import utilities.ShapeComparison;

public class BubbleSort
{
	public static void bubbleSort(Shape[] arr, char t)
	{
		int n = arr.length;
		for (int i=0;i < n - 1; i++)
		{
			boolean swapped = false;
			
			for (int j = 0; j < n - 1 - i; j++)
			{
				if (ShapeComparison.compare(arr[j], arr[j + 1], t) > 0)
				{
					Shape temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if (!swapped) 
			{
				break;
			}
		}
	}
}
