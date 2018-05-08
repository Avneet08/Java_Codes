package Algorithms;
//Avneet kaur
//2016233

public class Lab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
		long a=IFib((long)2353390967.0,2014);
		if (a==0){
		System.out.println(0);}
		else if (a==1){
			System.out.println(1);
		}
		else{
			System.out.println(a);
		}
		long endTime = System.currentTimeMillis();
		double TimeElapsed= (endTime-startTime)/1000.0; 
	
		System.out.println(TimeElapsed);
		
		
		int x=RFib(59,2014);
		if (x==0){
			System.out.println(0);}
			else if (x==1){
				System.out.println(1);
			}
			else{
				System.out.println(x);
			}
		long endTime1 = System.currentTimeMillis();
		
		double TimeElapsed1= (endTime1-startTime)/1000.0; 
		System.out.println(TimeElapsed1);
		long Y=CFib(8,2014);
		System.out.println(Y);
		long endTime2 = System.currentTimeMillis();
		double TimeElapsed2= (endTime1-startTime)/1000.0; 
	
		System.out.println(TimeElapsed1);
		

	}
	public static long IFib(long n,long m){
		long a=1;
		long b=1;
		if (n==0){
			return 0;
		}
		else if (n==1){
			return 1;
		}
		else{
			
			for(long i=2;i<n;i++){
			long temp=b;
			b=(a+b)% m;
			a=temp;
			}
		}
		return b;
	}
	public static int RFib(int n,int m){
		if (n==0){
			return 0;
		}
        else if (n==1){ return 1;}
        else {
        	return ((RFib(n-1,m) + RFib(n-2,m))% m);
        	}
}
	public static long CFib(long n,long m){
		long[][] A={{1,1},{1,0}};
		long[][] B={{1,0},{0,1}};
		n--;
		while(n>0){
			if(n%2==1){
				B=Multiply(A,B);
				
			}
			A=Multiply(A,A);
			n/=2;
		}
		return B[0][0]%m;
	}
	public static long[][] Multiply(long[][] a,long[][] b){
		long[][] m={{a[0][0]*b[0][0]+a[0][1]*b[1][0],a[0][0]*b[0][1]+a[0][1]*b[1][1]},{a[1][0]*b[0][0]+a[1][1]*b[1][0],a[1][0]*b[0][1]+a[1][1]*b[1][1]}};
		return m;
		}
	}
	
	
		
	
	

	


