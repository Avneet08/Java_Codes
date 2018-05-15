import java.math.BigInteger;
import java.util.Scanner;

public class changeSigns {
static int lastnegative=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 Long T=sc.nextLong();
		 for(int u=0;u<T;u++) {
			 lastnegative=0;
			 int N=sc.nextInt();
			 BigInteger arr[]=new BigInteger[N];
			 for(int i=0;i<N;i++) {
				 arr[i]=sc.nextBigInteger();
			 }
			changesigns(arr,N);
			 
		 }
	}
	static void changesigns(BigInteger arr[],int n) {
		int index=0;
		BigInteger arrcopy[] =new BigInteger[n];
		for(int i=0;i<n;i++) {
			arrcopy[i]=BigInteger.valueOf(1);
		}
		
		
		while(index<n) {
			if (index==0  ) {
				if(arr[index+1].compareTo(arr[index])==1 ) {
					arr[index]=arr[index].multiply(BigInteger.valueOf(-1));
					arrcopy[index]=BigInteger.valueOf(-1);
				}
				
			}
			else if (index==n-1 ) {
				if(arr[index-1].compareTo(arr[index])==1 ) {
					arr[index]=arr[index].multiply(BigInteger.valueOf(-1));
					arrcopy[index]=BigInteger.valueOf(-1);
				}
				
			}
		
			else if(arr[index+1].compareTo(arr[index])==1 && arr[index-1].compareTo(arr[index])==1) {
				arr[index]=arr[index].multiply(BigInteger.valueOf(-1));
				arrcopy[index]=BigInteger.valueOf(-1);
			}
			index++;
		}
		
		correctsigns(arr,arrcopy,n);
	}
	private static BigInteger sum(BigInteger[] arr,int i,int n) {
		BigInteger sum=BigInteger.valueOf(0);
		for(int u=i;u<n;u++) {
			sum=sum.add(arr[u]);
		}
		return sum;
		
	}

	private static void correctsigns(BigInteger[] arr,BigInteger[] arrcopy, int n) {
		int i=0,j=0;
		int lastnegative=0;
		for(i=0;i<n;i++) {
			if(arrcopy[i].compareTo(BigInteger.valueOf(-1))==0) {
				for(j=i+1;j<n;j++) {
					if(arrcopy[j].compareTo(BigInteger.valueOf(-1))==0) {
						BigInteger sum=sum(arr,i,j+1);
						if(sum.compareTo(BigInteger.valueOf(1))==1) {
							i=j;
							
						}else {
							if(arr[i].compareTo(arr[j])==1) {
								arr[lastnegative]=arr[lastnegative].multiply(BigInteger.valueOf(-1));
								arr[i]=arr[i].multiply(BigInteger.valueOf(-1));
								lastnegative=i;
							}
							else {
								arr[lastnegative]=arr[lastnegative].multiply(BigInteger.valueOf(-1));
								arr[j]=arr[j].multiply(BigInteger.valueOf(-1));
								lastnegative=j;
							}
							i=j;
							
						}
					}
				}
			}
			
		}BigInteger x=sum(arr,0,n);
		for( i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println(" ");
	
	}
	

}
