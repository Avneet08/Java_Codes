package DSA;

import java.util.Scanner;

public class Average_foobar {

	public static void main(String[] args) {
		Average_foobar arr=new Average_foobar();
		arr.avg();
		// TODO Auto-generated method stub

	}
	private static void avg(){
		Scanner input=new Scanner(System.in);
		int N=input.nextInt();
		int avg=0;
		int num=0;
		int[] arr=new int[N];
		for(int i=0;i<N;i++){
			int A=input.nextInt();
			arr[i]=A;
			avg+=A/N;
			}
		for(int j=0;j<N;j++){
			if(arr[j]>avg){
				num++;
			}
		}
		System.out.println(num);
	}

}
