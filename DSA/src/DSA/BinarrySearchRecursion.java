package DSA;

public class BinarrySearchRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={0,1,2,4,7,9};
		
		 int recursiveIndex=BinarrySearchwithRecursion(arr,0,0,arr.length-1);
		 
		if(recursiveIndex==-1)
		   System.out.println("Element you are searching for is not found!");
		else
		   System.out.println("Element at an Index position "+recursiveIndex);
		 
	}
	public static int BinarrySearchwithRecursion(int[] arr,int x ,int low,int high){
		if (low>high){
		return -1;}
		int mid=(low +high)/2;
		if (arr[mid]==x){
			return mid;
			
		}
		else if (arr[mid] < x){
			return BinarrySearchwithRecursion(arr, x, mid+1, high);}
		else{
			return BinarrySearchwithRecursion(arr, x, low, mid-1);
		}
	}

}
