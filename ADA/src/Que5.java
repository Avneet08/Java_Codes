import java.util.ArrayList;

public class Que5 {
private static int Compare(ArrayList<Integer> arr1,ArrayList<Integer> arr2){
	int S1=Sum(arr1);
	int S2=Sum(arr2);
	if(S1>S2){
		return 1;
		
	}
	else if(S2>S1){
		return 2;
		
	}
	else {
		return 0;
		
	}
	
}
	private static int Sum(ArrayList<Integer> arr2) {
		int sum = 0;
		for(int d : arr2)
		    sum += d;
		return sum;
	
}
	public static int Divide(int arr[],int L,int count){
		if(L==1){
			return count;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
