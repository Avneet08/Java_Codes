import java.util.ArrayList;
import java.util.Scanner;

public class SJF {
	public double poissonRandomInterarrivalDelay(double L) {
	    return (Math.log(1.0-Math.random())/-L);
	}
	public double nextExponential(double b) {
    	double randx;
		 double result;
		randx = Math.random();
		result = -1*b*Math.log(randx);
		return result;
		
    }
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
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SJF o=new SJF();
		ArrayList<Long> arrivalt=new ArrayList<Long>();
		ArrayList<Double> burstt=new ArrayList<Double>();
		ArrayList<Double> avgwaitingt=new ArrayList<Double>();
		ArrayList<Double> turnaroundt=new ArrayList<Double>();
		Scanner sc=new Scanner(System.in);  
		System.out.println("Enter the initial running time");  
		   int time=sc.nextInt();  
		   //double x=(100.0/9000.0);
		   double x=(100.0/1000.0*time);
		   long startTime= System.currentTimeMillis();
			long end = startTime+1000*time;
			
			while(System.currentTimeMillis()<end)
			{long interval= (long)o.poissonRandomInterarrivalDelay(x);
			Thread.sleep(1);
			//System.out.println(interval);
			arrivalt.add(interval);
			}
			int sizeat=0;
			int b=25;
			while(sizeat<arrivalt.size())
			{
				double value=o.nextExponential(b);
				Thread.sleep(1);
				//System.out.println(value);
				burstt.add(value);
				sizeat++;
			}
			System.out.println(arrivalt.size());
			System.out.println(burstt.size());
			 long startTime2= System.currentTimeMillis();
				long end2= startTime2+time*60000;
				double s=0;
		avgwaitingt.add(0,  0.0);
		double avgwt=0;
		double total=0;
		double avgtat=0;
		o.sort(burstt, 0, burstt.size()-1);
		//burstt.forEach(System.out::println);
		avgwaitingt.add(0,  0.0);
		
	
		for(int j=1;j<arrivalt.size();j++){
			double t=avgwaitingt.get(j-1);
		avgwaitingt.add(j, t+burstt.get(j-1));
		 
		total+=avgwaitingt.get(j);
		}
		avgwt=(float)total/arrivalt.size();
		int total2=0;
		
		for(int i=0;i<arrivalt.size();i++)
		{
			turnaroundt.add(i,burstt.get(i)+avgwaitingt.get(i) );
		total2+=turnaroundt.get(i);
		//System.out.println("\n p"+process[i]+"\t\t "+burst_time[i]+"\t\t "+waiting_time[i]+"\t\t "+tat[i]);
		}
		System.out.println("  ArrivalTime\t\tBURST-TIME\tWAITING-TIME\tTURN AROUND-TIME\n"); 
		for(int i=0;i<arrivalt.size();i++) 
		{
		System.out.println("          "+ i+" " + "\t\t"+burstt.get(i)+"\t"+avgwaitingt.get(i)/1000+"\t"+turnaroundt.get(i));
		} 
		 
		//Calculation of Average Turnaround Time
		avgtat=(float)total2/arrivalt.size();
		System.out.println("\n\nAverage Waiting Time: "+avgwt/1000);
		System.out.println("\nAverage Turnaround Time: "+avgtat/1000);
		System.out.println(arrivalt.size()+" "+turnaroundt.size());
	}

}
