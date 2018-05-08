import java.util.ArrayList;
import java.util.Scanner;

public class Round_Robin {
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
	
	public static void main(String[] args) throws InterruptedException{
		Round_Robin o=new Round_Robin();
		ArrayList<Long> arrivalt=new ArrayList<Long>();
		ArrayList<Double> burstt=new ArrayList<Double>();
		ArrayList<Double> rem=new ArrayList<Double>();
		ArrayList<Double> avgwaitingt=new ArrayList<Double>();
		ArrayList<Double> turnaroundt=new ArrayList<Double>();
		Scanner sc=new Scanner(System.in);  
		System.out.println("Enter the initial running time");  
		int time=sc.nextInt();  
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
			rem.add(value);
			sizeat++;
		}
		int q=2;
		System.out.println(arrivalt.size());
		System.out.println(burstt.size());
		long startTime2= System.currentTimeMillis();
		long end2= startTime2+time*60000;
		double s=0;
		avgwaitingt.add(0,  0.0);
		double avgwt=0;
		double total=0;
		double avgtat=0;
		o.sort(arrivalt, 0, arrivalt.size()-1);
		//burstt.forEach(System.out::println);

		int flag;
		/*do{

			flag=0;
			for(int i=0;i<arrivalt.size();i++)
			{
				if(rem.get(i)>0)
				{
					System.out.print("P"+(i+1)+"\t");
					for(int j=0;j<arrivalt.size();j++)
					{
						if(j==i)
							rem.set(i, 0.0) ;
						else if(rem.get(j)>0){
							
							avgwaitingt.set(j,avgwaitingt.get(j)+rem.get(i));
						}
					}
				}
			else if(rem.get(i)>=q)
				{
					System.out.print("P"+(i+1)+"\t");
					for(int j=0;j<arrivalt.size();j++)
					{
						if(j==i)
							rem.set(i, rem.get(i)-q);

						else if(rem.get(j)>0)
							avgwaitingt.set(j,avgwaitingt.get(j)+q);

					}
				}
				 
			}
			for(int i=0;i<arrivalt.size();i++)
				if(rem.get(i)>0)
					flag=1;
		}while(flag==1);
		for(int i=0;i<arrivalt.size();i++){
			double o1=avgwaitingt.get(i);
			turnaroundt.add(i,o1+burstt.get(i) ); 


		}*/
		double t=0;
		 while(true)
	        {
	            boolean done = true;
	            for (int i = 0 ; i < arrivalt.size(); i++)
	            {
	                if (rem.get(i) > 0)
	                {
	                    done = false; 
	                    if (rem.get(i) > q)
	                    {t += q;
	                  
	                        rem.set(i, rem.get(i)-q);
	                    }
	                    else
	                    {
	                    	t = t + rem.get(i);
	                    	//avgwaitingt.add(i,t-burstt.get(i));
	                        avgwaitingt.add(t-burstt.get(i));
	                       rem.set(i,0.0) ;
	                    }
	                }
	            }
	      
	            // If all processes are done
	            if (done == true)
	              break;
	        }
		 for(int i=0;i<arrivalt.size();i++){
				double o1=avgwaitingt.get(i);
				turnaroundt.add(o1+burstt.get(i) ); 
		 }
		//System.out.println("\nProcess\tBurst\tWaiting\tTurnaround");
		int b1=0;
		int t1=0;
		System.out.println(avgwaitingt.size()+"     "+turnaroundt.size());
		for(int i=0;i<arrivalt.size();i++)
		{
			//System.out.println("P"+(i+1)+"\t"+bur[i]+"\t"+avgwaitingt.get(i)+"\t"+ta[i]);
			b1+=avgwaitingt.get(i);
			t1+=turnaroundt.get(i);
		}
		System.out.println("  ArrivalTime\t\tBURST-TIME\tWAITING-TIME\tTURN AROUND-TIME\n"); 
		for(int i=0;i<arrivalt.size();i++) 
		{
		System.out.println("          "+ i+" " + "\t\t"+burstt.get(i)+"\t"+avgwaitingt.get(i)/1000+"\t"+turnaroundt.get(i)/1000);
		} 
		System.out.println("Average waiting time:"+(b1/arrivalt.size()));
		System.out.println("Average Turnaround time:"+(t1/arrivalt.size()));
	}
}
