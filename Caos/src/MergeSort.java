import java.util.ArrayList;

public class MergeSort {
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
	 
	    /* A utility function to print array of size n */
	    static void printArray(ArrayList<Double> bt)
	    {
	        int n = bt.size();
	        for (int i=0; i<n; ++i)
	            System.out.print(bt.get(i) + " ");
	        System.out.println();
	    }
	 
	    // Driver method
	    public static void main(String args[])
	    {
	    	ArrayList<Double> bt=new ArrayList<Double>();
	    	bt.add(13.27);
	    	bt.add(115.6);
	    	bt.add(163.229);
	    	bt.add(13.2373);
	    	bt.add(13.0);
	    	
	        
	 
	        System.out.println("Given Array");
	        printArray(bt);
	 
	        MergeSort ob = new MergeSort();
	        ob.sort(bt, 0, bt.size()-1);
	 
	        System.out.println("\nSorted array");
	        printArray(bt);
	    }
}
