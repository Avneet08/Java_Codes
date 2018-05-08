import java.util.ArrayList;
import java.util.Scanner;

public class priority {
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
	void merge(ArrayList<Long> arrivalt, int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		
		Long L[] = new Long [n1];
		Long R[] = new Long [n2];

		
		for (int i=0; i<n1; ++i)
			L[i] = arrivalt.get(l + i);
		for (int j=0; j<n2; ++j)
			R[j] = arrivalt.get(m + 1+ j);

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arrivalt.set(k, L[i]);
				i++;
			}
			else
			{
				arrivalt.set(k, R[j]);
				j++;
			}
			k++;
		}

		
		while (i < n1)
		{
			arrivalt.set(k, L[i]);
			i++;
			k++;
		}

		
		while (j < n2)
		{
			arrivalt.set(k, R[j]);
			j++;
			k++;
		}
	}
	void sort(ArrayList<Long> arrivalt, int l, int r)
	{
		if (l < r)
		{
			// Find the middle point
			int m = (l+r)/2;

			// Sort first and second halves
			sort(arrivalt, l, m);
			sort(arrivalt , m+1, r);

			// Merge the sorted halves
			merge(arrivalt, l, m, r);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		priority o=new priority();
		ArrayList<Long> arrivalt=new ArrayList<Long>();
		ArrayList<Long> priority=new ArrayList<Long>();
		ArrayList<Double> burstt=new ArrayList<Double>();
		ArrayList<Double> avgwaitingt=new ArrayList<Double>();
		ArrayList<Double> turnaroundt=new ArrayList<Double>();
		Scanner sc=new Scanner(System.in);  
		System.out.println("Enter the initial running time");  
		   int time=sc.nextInt();  
		   double x=(100.0/9000.0);
		   long startTime= System.currentTimeMillis();
			long end = startTime+9000;
			
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
				long s=(long) Math.random();
				priority.add(s);
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
		o.sort(priority, 0, priority.size()-1);
		turnaroundt.add(0,burstt.get(0));
		avgtat=turnaroundt.get(0);
		//avgwaitingt.add(i,burstt.get(i-1)+avgwaitingt.get(i-1));
			for(int i=1;i<arrivalt.size();i++)
		{
			avgwaitingt.add(i,turnaroundt.get(i-1));
			turnaroundt.add(i,burstt.get(i)+avgwaitingt.get(i) );
			avgtat+=turnaroundt.get(i);
			avgwt+=avgwaitingt.get(i);
			
		}
			//avgwaitingt.forEach(System.out::println);
			int y=0;
		for (int i=1;i<arrivalt.size();i++){
			y++;
		}
		//System.out.println(avgwt);
		System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
		for(int i=0;i<arrivalt.size();i++)
			//System.out.print("\n   "+p[i]+"\t\t   "+bt[i]+"\t\t     "+w[i]+"\t\t     "+t[i]+"\t\t     "+pp[i]+"\n");
		avgwt=avgwt;//arrivalt.size();
		avgtat/=arrivalt.size()*10000;
		System.out.println("  ArrivalTime\t\tBURST-TIME\tWAITING-TIME\tTURN AROUND-TIME\n"); 
		for(int i=0;i<arrivalt.size();i++) 
		{
		System.out.println("          "+ i+" " + "\t\t"+burstt.get(i)+"\t"+avgwaitingt.get(i)/1000+"\t"+turnaroundt.get(i)/1000);
		} 
		System.out.print("\n Average Wait Time : "+avgwt);
		System.out.print("\n Average Turn Around Time : "+avgtat);
			//System.out.println(avgwaitingt.size());
			//turnaroundt.forEach(System.out::println);

	}
		
	}


