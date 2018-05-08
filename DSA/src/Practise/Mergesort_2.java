package Practise;

public class Mergesort_2 {
void merge(int[] arr,int first,int mid,int last)
{
	int n1=mid-first+1;
	int n2=last-mid;
	int D[]=new int[n1];
	int R[]=new int[n2];
	for(int i=0;i<n1;i++){
		D[i]=arr[first+i];
		
	}
	for(int j=0;j<n2;j++){
		R[j]=arr[j+mid+1];
		
	}
	int i=0, j=0;
	int k=first;
	while(i<n1 && j<n2){
		if(D[i]<=R[j]){
			arr[k]=D[i];
			i++;
		}
		else{
			arr[k]=R[j];
			j++;
			
		}
		k++;
		while(i<n1){
			arr[k]=D[i];
			i++;
			k++;
	}
		while(j<n2){
			arr[k]=R[j];
			j++;
			k++;
			}
	}
	
		
	}
void Sortarr(int arr[],int first,int last){
	if(first<last){
		int mid=(last+first)/2;
		Sortarr( arr, first,mid);
		Sortarr( arr, mid+1,last);
		merge(arr,first,mid,last);
		
		
		
	}
}
void PrintArray(int[] arr){
for(int i=0;i<arr.length;++i){
	System.out.print(arr[i]+" "); 
	
}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={5,8,2,9,1,45,34,87,12,90,53,98,67,1,23,12};
Mergesort_2 o=new Mergesort_2();
o.Sortarr(arr, 0, arr.length-1);
o.PrintArray(arr);
	}

}
