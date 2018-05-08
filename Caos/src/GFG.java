import java.util.ArrayList;
import java.util.Scanner;

public class GFG {
	void merge(ArrayList<Double> bt, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        double L[] = new double [n1];
        double R[] = new double [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = bt.get(l + i);
        for (int j=0; j<n2; ++j)
            R[j] = bt.get(m + 1+ j);
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
            	bt.set(k, L[i]);
                i++;
            }
            else
            {
            	bt.set(k, R[j]);
            	j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            bt.set(k, L[i]);
            i++;
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (j < n2)
        {
        	bt.set(k, R[j]);
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(ArrayList<Double> bt, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(bt, l, m);
            sort(bt , m+1, r);
 
            // Merge the sorted halves
            merge(bt, l, m, r);
        }
    }
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);

		int x,n,p[],pp[],bt[],w[],t[],awt,atat,i;

		p = new int[10];
		pp = new int[10];
		bt = new int[10];
		w = new int[10];
		t = new int[10];

		//n is number of process
		//p is process
		//pp is process priority
		//bt is process burst time
		//w is wait time
		// t is turnaround time
		//awt is average waiting time
		//atat is average turnaround time


		System.out.print("Enter the number of process : ");
		n = s.nextInt();
		System.out.print("\n\t Enter burst time : time priorities \n");

		for(i=0;i<n;i++)
		{
			System.out.print("\nProcess["+(i+1)+"]:");
			bt[i] = s.nextInt();
			pp[i] = s.nextInt();
			p[i]=i+1;
		}

		//sorting on the basis of priority
		/*for(i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(pp[i]<pp[j])
				{
					x=pp[i];
					pp[i]=pp[j];
					pp[j]=x;
					x=bt[i];
					bt[i]=bt[j];
					bt[j]=x;
					x=p[i];
					p[i]=p[j];
					p[j]=x;
				}
			}
		}*/
		
		w[0]=0;
		awt=0;
		t[0]=bt[0];
		atat=t[0];
		for(i=1;i<n;i++)
		{
			w[i]=t[i-1];
			awt+=w[i];
			t[i]=w[i]+bt[i];
			atat+=t[i];
		}

		//Displaying the process

		System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
		for(i=0;i<n;i++)
			System.out.print("\n   "+p[i]+"\t\t   "+bt[i]+"\t\t     "+w[i]+"\t\t     "+t[i]+"\t\t     "+pp[i]+"\n");
		awt/=n;
		atat/=n;
		System.out.print("\n Average Wait Time : "+awt);
		System.out.print("\n Average Turn Around Time : "+atat);

	}
}