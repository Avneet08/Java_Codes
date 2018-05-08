package Practise;
class Priority_Queue1{
	private int maxSize;
	private long[] Array;
	private int Items;
	public Priority_Queue1(int s){
		maxSize=s;
		Array=new long[maxSize];
		Items=0;
		
	}
	public void Insert(long Item){
		int j;
		if(Items==0) // if no items,
		Array[Items++] = Item; // insert at 0
		else // if items,
		{
		for(j=Items-1; j>=0; j--) // start at end,
		{
		if( Item > Array[j] ) // if new item larger,
		Array[j+1] = Array[j]; // shift upward
		
		else // if smaller,
		break; // done shifting
		} // end for
		Array[j+1] = Item; // insert it
		Items++;
		} // end else (nItems > 0)
		} // end insert()
		//-------------------------------------------------------------
		public long remove() // remove minimum item
		{ return Array[--Items]; }
		//-------------------------------------------------------------
		public long peekMin() // peek at minimum item
		{ return Array[Items-1]; }
		//-------------------------------------------------------------
		public boolean isEmpty() // true if queue is empty
		{ return (Items==0); }
		//-------------------------------------------------------------
		public boolean isFull() // true if queue is full
		{ return (Items == maxSize); }
		//-------------------------------------------------------------
		
		
	}

public class priority_Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Priority_Queue1 que=new Priority_Queue1(10);
		que.Insert(50);
		
	}

}
