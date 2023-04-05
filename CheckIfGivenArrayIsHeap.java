package Problems;

public class CheckIfGivenArrayIsHeap {

	public static boolean isHeap(int arr[], int index, int size)
	{
		// Time complexity: O(n)
		// Auxilary space: O(h)
		// If (2 * index) + 1 >= size, 
		// then leaf node, so return true
		if (index >= (size - 1) / 2)
		{
			return true;
		}
		
		return arr[index] >= arr[2 * index + 1]
				&&
			   arr[index] >= arr[2 * index + 1]
				&&
			   isHeap(arr, 2 * index + 1, size)
			    &&
			   isHeap(arr, 2 * index + 2, size);
				
	}
	
	public static boolean isHeapIterative(int arr[], int size)
	{
		// Time complexity: O(n)
		// Start from root and go till the last internal 
        // node 
        for (int i = 0; i <= (size - 2) / 2; i++) 
        {
            // If left child is greater, return false 
            if (arr[2 * i + 1] > arr[i]) 
            {
                return false;
            }
  
            // If right child is greater, return false 
            if (2 * i + 2 < size && arr[2 * i + 2] > arr[i]) 
            {
                return false;
            }
        }
        return true;
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = { 90, 15, 10, 7, 12, 2, 7, 3 };
        int n = arr.length - 1;
        
        if (isHeap(arr, 0, n)) 
        {
            System.out.println("Yes");
        }
        else 
        {
            System.out.println("No");
        }
	}

}
