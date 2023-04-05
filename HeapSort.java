package Problems;

public class HeapSort {

	public static void sort(int arr[])
	{
		// build the initial heap
		buildHeap(arr);
		
		// repeat until the heap contains only one element
		for (int i = arr.length - 1; i >= 1; i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			// Remove the last element (which is now in the correct position)
			int heapSize = i;
			heapify(arr, 0, heapSize);
		}
		reverseArray(arr);	
	}
	
	private static void reverseArray(int[] arr) {
	    
		int n = arr.length;
	    
		for (int i = 0; i < n / 2; i++) 
		{
	      int temp = arr[i];
	      arr[i] = arr[n - i - 1];
	      arr[n - i - 1] = temp;
	    }
	  }
	
	private static void buildHeap(int[] arr)
	{
	    // Build a max heap from the input array
	    int n = arr.length;
	    for (int i = n/2 - 1; i >= 0; i--)
	    {
	    	heapify(arr, i, n);
	    }
	}
	
	
	
	private static void heapify(int[] arr, int i, int heapSize)
	{
		// heapify the subtree rooted at i in the input array
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if (left < heapSize && arr[left] > arr[largest])
		{
			largest = left;
		}
		
		if (right < heapSize && arr[right] > arr[largest])
		{
			largest = right;
		}
		
		if (largest != i)
		{
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, largest, heapSize);
		}
			
	}
	
	
	
	public static void main(String[] args) {
		
		 int[] arr = {5, 2, 9, 1, 5, 6};
		   
		 sort(arr);
		  
		 System.out.print("[");
		    
		 for (int i=0; i<arr.length-1; i++) 
		 {
		      System.out.print(arr[i] + ", ");
		 }
		  
		 System.out.print(arr[arr.length-1] + "]");
		  

	}

}
