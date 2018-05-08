package Practise;
class StackX
{
private final int SIZE = 20;
private int[] st;
private int top;
// -----------------------------------------------------------
public StackX() // constructor
{
st = new int[SIZE]; // make array
top = -1;
}
// -----------------------------------------------------------
public void push(int j) // put item on stack
{ st[++top] = j; }
// -----------------------------------------------------------
public int pop() // take item off stack
{ return st[top--]; }
// ------------------------------------------------------------
public int peek() // peek at top of stack

{ return st[top]; }
// ------------------------------------------------------------
public boolean isEmpty() // true if nothing on stack-
{ return (top == -1); }
// ------------------------------------------------------------
} // end class StackX
////////////////////////////////////////////////////////////////
class Vertex1
{
public char label; // label (e.g. ‘A’)
public boolean wasVisited;
// ------------------------------------------------------------
public Vertex1(char lab) // constructor
{
label = lab;
wasVisited = false;
}
// ------------------------------------------------------------
} // end class Vertex1
////////////////////////////////////////////////////////////////
class GPH
{
private final int MAX_VERTS = 20;
private Vertex1 Vertex1List[]; // list of vertices
private int adjMat[][]; // adjacency matrix
private int nVerts; // current number of vertices
private StackX theStack;
// -----------------------------------------------------------
public GPH() // constructor
{
Vertex1List = new Vertex1[MAX_VERTS];
// adjacency matrix
adjMat = new int[MAX_VERTS][MAX_VERTS];
nVerts = 0;
for(int j=0; j<MAX_VERTS; j++) // set adjacency
for(int k=0; k<MAX_VERTS; k++) // matrix to 0
adjMat[j][k] = 0;
theStack = new StackX();
} // end constructor
// -----------------------------------------------------------
public void addVertex1(char lab)

{
Vertex1List[nVerts++] = new Vertex1(lab);
}
// -----------------------------------------------------------
public void addEdge(int start, int end)
{
adjMat[start][end] = 1;
adjMat[end][start] = 1;
}
// ------------------------------------------------------------
public void displayVertex1(int v)
{
System.out.print(Vertex1List[v].label);
}
// ------------------------------------------------------------
public void dfs() // depth-first search
{ // begin at Vertex1 0
	Vertex1List[0].wasVisited = true; // mark it
	displayVertex1(0); // display it
	theStack.push(0); // push it
	while( !theStack.isEmpty() ) // until stack empty,
	{
		// get an unvisited Vertex1 adjacent to stack top
		int v = getAdjUnvisitedVertex1( theStack.peek() );
		if(v == -1) // if no such Vertex1,
			theStack.pop();
		else // if it exists,
		{
		Vertex1List[v].wasVisited = true; // mark it
		displayVertex1(v); // display it
		theStack.push(v); // push it
}
} // end while
// stack is empty, so we’re done
for(int j=0; j<nVerts; j++) // reset flags
Vertex1List[j].wasVisited = false;
} // end dfs
// ------------------------------------------------------------
// returns an unvisited Vertex1 adj to v

public int getAdjUnvisitedVertex1(int v)
{
	for(int j=0; j<nVerts; j++)
		if(adjMat[v][j]==1 && Vertex1List[j].wasVisited==false)
		return j;
		return -1;
	} // end getAdjUnvisitedVertex1()
public void mst() // minimum spanning tree (depth first)
	{ // start at 0
	Vertex1List[0].wasVisited = true; // mark it
	theStack.push(0); // push it
	while( !theStack.isEmpty() ) // until stack empty
		{ 
		
		int currentVertex = theStack.peek();
		// get next unvisited neighbor
		int v = getAdjUnvisitedVertex1(currentVertex);
		if(v == -1) // if no more neighbors
			theStack.pop(); // pop it away
	else // got a neighbor
		{
		Vertex1List[v].wasVisited = true; // mark it
		theStack.push(v); // push it
	// display edge
		displayVertex1(currentVertex); // from currentV
		displayVertex1(v); // to v
		System.out.print(" ");
}
} // end while(stack not empty)
// stack is empty, so we’re done
for(int j=0; j<nVerts; j++) // reset flags
Vertex1List[j].wasVisited = false;
} // end tree
// -------------------------------------------------------------
// ------------------------------------------------------------
} 
public class DFS {
	public static void main(String[] args)
	{
	GPH theGPH = new GPH();
	theGPH.addVertex1('A'); // 0 (start for dfs)
	theGPH.addVertex1('B'); // 1
	theGPH.addVertex1('C'); // 2
	theGPH.addVertex1('D'); // 3
	theGPH.addVertex1('E'); // 4
	theGPH.addEdge(0, 1); // AB
	theGPH.addEdge(1, 2); // BC
	theGPH.addEdge(0, 3); // AD
	theGPH.addEdge(3, 4); // DE
	System.out.print("Visits: ");
	theGPH.dfs(); // depth-first search
	System.out.println();
	theGPH.mst(); // minimum spanning tree
	System.out.println();
	} // end main()
}
