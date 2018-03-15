
public class Stack {
	private int[] Object;
	private int top;
	private int StackSize;
	public Stack(){
		StackSize=1;
		top=-1;
		Object = new int[StackSize];
		
	}
	public void push(int item){
		if(top>=StackSize-1)
			resize();
		Object[++top]=item;
		}
	public int pop(){
		if (top<0)
			return null;
	}	private void resize(){
		int[] temp=Object;
		StackSize=StackSize*2;
		Object=new int[StackSize];
		for (int i=0;i<=top;i++)
			Object[i]=temp[i];
		
	}
}
