package cs3112.edu;

/*Suppose we have a sorted sequence A and would like to check if a
value v is in A, we can check the midpoint of the sequence against
v and eliminate half of the sequence from further consideration.
The binary search algorithm repeats this procedure, halving the
size of the remaining portion of the sequence each time.
Implements binary search.*/

public class ProblemTwo {
	 //returns index of x if present in array, else returns -1
    int binarySearch(int array[], int l, int r, int x)
    {
        if (r >= l)
        {
            int mid = l + (r - l)/2;

            //if the element is present at middle 
            if (array[mid] == x)
               return mid;

            //if element is smaller than middle, it can only be present in left subarray
            if (array[mid] > x)
               return binarySearch(array, l, mid - 1, x);

            //else element can only be present in right subarray
            return binarySearch(array, mid + 1, r, x);
        }

        //this is reached when element not present in array
        return -1;
    }

    public static void main(String args[])
    {
        ProblemTwo ob = new ProblemTwo();
        
        //sorted list
        int[] array1 = {1, 10, 50, 60, 70};

		//prints list
		System.out.println("Sorted List:");
		for(int i = 0; i < array1.length; i++)
		{
			System.out.print(array1[i]);
			
			if(i == array1.length - 1)
			{
				System.out.print(".");
			}
			
			else
			{
				System.out.print(", ");
			}
		}	
		
        int n = array1.length;
        
        //search for a 10
        int x = 11;
        
        System.out.println();
        System.out.println();
        System.out.println("Binary Search for 10:");
        
        //calls binary search
        int result = ob.binarySearch(array1, 0, n-1, x);
        
        if (result == -1)
        {
            System.out.println("Element not present.");
        }
        else
        {
            System.out.println("Element found at index " + result + ".");
        }
    }
}
