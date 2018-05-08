package DSA;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,4,5,3,2,0,8,6};
		
		 int recursiveIndex=linearSearchWithRecursion(arr,0,0,arr.length-1);
		 
		if(recursiveIndex==-1)
		   System.out.println("Element you are searching for is not found!");
		else
		   System.out.println("Element at an Index position "+recursiveIndex);
		 
		}
	
	
public static int linearSearchWithRecursion( int[] keys, int key, int low, int high ) {
if (low > high) {
// There are no more keys left.
return -1;
} else if (keys[ low ] != key) {
// Search for key in remaining keys.
return linearSearchWithRecursion( keys, key, low + 1, high );
} else {
// We’ve located key.
return low;
 }
}
	
}
