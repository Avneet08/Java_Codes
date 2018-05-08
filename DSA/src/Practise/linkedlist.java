package Practise;


class Nodei {
	private int data;
	private Nodei link;
	
	public Nodei(int givendata, Nodei givenlink) {
		//THIS IS THE CONSTRUCTOR TO INITIALISE THE NODE
		this.data = givendata;
		this.link = givenlink;
	}
	
	public void setData(int givendata) {
		//THE DATA PARAMETER IS SET INDIVIDUALLY
		this.data = givendata;
	}
	
	public void setLink(Nodei givenlink) {
		//THE LINK PARAMETER IS SET INDIVIDUALLY
		this.link = givenlink;
	}
	public Nodei getLink() {
        return link;
    }
	public int getData() {
		return data;
	}
}
public class linkedlist {
	public Nodei front;
	static Nodei top;
	public void insertempty(int num){
		Nodei nptr=new Nodei(num,null);
	
		if (front==null ){
			front=nptr;
		}
		else  
		{
		       Nodei ptr = front;
		       
		        while (ptr.getLink()  != null)
		            ptr = ptr.getLink();
		       ptr.setLink(nptr);
		}

	}
	boolean compare(linkedlist dl ){
		Nodei ptr = this.front, ptr1 = dl.front;
		while(ptr.getLink()!=null && ptr1.getLink()!=null){
				if (ptr.getData()!=ptr1.getData()){
					return false;
					}
				else{
					if(ptr.getLink()==null && ptr1.getLink()==null){
						return true;
					}
					ptr=ptr.getLink();
					ptr1=ptr1.getLink();
					
				}
				}
				
				return (ptr==null && ptr1==null);
				
			}
		
		
	
	void insertatpos(int Nod,int pos){
		Nodei nptr = new Nodei(Nod, null);                
        Nodei ptr = front;
        pos = pos - 1 ;
        for (int i = 1; i < 10; i++)             {
            if (i == pos)                 {
                Nodei tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }

	}
	void FindnSwap(int val,int swap){
		Nodei pre=front;
		Nodei cur=front.getLink();
		Nodei next=cur.getLink();
		Nodei nptr=new Nodei(swap,null);
		while(cur.getLink()!=null){
			if(cur.getData()==val){
				pre.setLink(nptr);
				nptr.setLink(next);
			}
			cur=cur.getLink();
		}
	}
	 Nodei reverse() {
        Nodei prev = null;
        Nodei current = front;
        Nodei next = null;
        while (current != null) {
        	next=current.getLink();
           // current.setLink(next);
        	current.setLink(prev) ;
            prev = current;
            current = next;
            //next.setLink(current);
            
            
        }
        front = prev;
        return front;
    }

	void Display(){
		Nodei head=front;
		while(head.getLink() != null){
			System.out.print(head.getData()+ " ");
			head = head.getLink();
		}
		System.out.print(head.getData());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedlist cl = new linkedlist();
		
		cl.insertempty(45);
		cl.insertempty(67);
		cl.insertempty(54);
		cl.insertempty(78);
		cl.Display();
		System.out.println('\n');
		cl.reverse();
	    cl.Display();
	    System.out.println('\n');
		
		linkedlist dl = new linkedlist();
		dl.insertempty(45);
		dl.insertempty(67);
		dl.insertempty(54);
		dl.insertempty(78);
		dl.Display();
		
		
		System.out.println('\n');
		
		if (dl.compare(cl)==false){
			System.out.println(" not Identical");
		}
		else{
			System.out.println(" identical");
		}
		
		cl.insertatpos(98, 4);
		cl.FindnSwap(67, 69);
		
		System.out.println('\n');
		
		
		
		
		
		
		
		
		dl.Display();
		System.out.println('\n');
		dl.insertatpos(98, 4);
		dl.Display();
		System.out.println('\n');
		dl.FindnSwap(67, 69);
		
		cl.reverse();
		cl.Display();
		
	}

}
