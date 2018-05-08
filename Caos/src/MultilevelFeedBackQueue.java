import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MultilevelFeedBackQueue {
	static int timeslice=2;
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
	public static void main(String[] args) throws IOException, InterruptedException  {
		MultilevelQueue c=new MultilevelQueue();
		Scanner sc=new Scanner(System.in);
		ArrayList<Long> p=new ArrayList<Long>();
		ArrayList<Long> t=new ArrayList<Long>();
		ArrayList<Long> y=new ArrayList<Long>();
		ArrayList<Long> bt=new ArrayList<Long>();
		ArrayList<Long> su=new ArrayList<Long>();
		ArrayList<Long> wt=new ArrayList<Long>();
		ArrayList<Long> tat=new ArrayList<Long>();
		System.out.println("Enter the initial running time");  
		   int time=sc.nextInt();  
		   double x=(100.0/9000.0);
		   long startTime= System.currentTimeMillis();
			long end = startTime+9000;
			
			while(System.currentTimeMillis()<end)
			{long interval= (long)c.poissonRandomInterarrivalDelay(x);
			Thread.sleep(1);
			//System.out.println(interval);
			su.add(interval);
			}
			int sizeat=0;
			int b=25;
			while(sizeat<su.size())
			{
				Long value=(long) c.nextExponential(b);
				Thread.sleep(1);
				//System.out.println(value);
				bt.add(value);
				sizeat++;
			}
			System.out.println(su.size());
			System.out.println(bt.size());
		/*int p[]=new int[20];
		int bt[]=new int[20]; 
		int su[]=new int[20] ;
		int wt[]=new int[20];
			int tat[]=new int[20];*/
		int i, k, n;
		Long temp;
		float wtavg, tatavg;
		//System.out.println("Enter the number of processes --- ");
		n= su.size();
		wtavg  = 0;
		wt.add((long) 0);
		tatavg  = bt.get(0);
		tat.add(bt.get(0));
		for(i=0;i<n;i++)
		{
			p.add((long) i);
		
		}
		
		for(i=0;i<n;i++)
		for(k=i+1;k<n;k++)
		if(su.get(i)>su.get(k))
		{
		temp=p.get(i);
		p.set(i,(long) k);
		p.set(k, temp);
		temp=bt.get(i);
		bt.set(i, (long) k);
		bt.set(k, temp);
		temp=su.get(i);
		su.set(i,(long) k);
		su.set(k, temp);
		}
		
		for(i=1;i<n;i++)
		{
		wt.add(i,wt.get(i-1)+bt.get(i-1));
		tat.add(i,tat.get(i-1)+bt.get(i-1));
		
		}
		for(i=0;i<n;i++){
			wtavg = wtavg + wt.get(i);
			tatavg = tatavg + tat.get(i);
		}
		
		/*System.out.println("\nPROCESS\t\t SYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
		for(i=0;i<n;i++)
			System.out.println(p[i]+" "+su[i]+" "+bt[i]+" "+wt[i]+" "+tat[i]);*/
		System.out.println("  ArrivalTime\t\tBURST-TIME\tWAITING-TIME\tTURN AROUND-TIME\n"); 
		for(int j=0;i<su.size();i++) 
		{
		System.out.println("          "+ su.get(i)+" "+i+" " + "\t\t"+bt.get(i)+"\t"+wt.get(i)+"\t"+tat.get(i));
		} 
		System.out.println("\nAverage Waiting Time is --- "+wtavg/n*100000);
		System.out.println("\nAverage Turnaround Time is ---"+tatavg/n*100000);
		
	}
}
