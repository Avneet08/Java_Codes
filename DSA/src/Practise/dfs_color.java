package Practise;
public class dfs_color {
	public static void main(String[] args)
	{
	GPHi theGPHi = new GPHi();
	theGPHi.addVertex3('A'); // 0 (start for dfs)
	theGPHi.addVertex3('B'); // 1
	theGPHi.addVertex3('C'); // 2
	theGPHi.addVertex3('D'); // 3
	theGPHi.addVertex3('E'); // 4
	theGPHi.addEdge(0, 1); // AB
	theGPHi.addEdge(1, 2); // BC
	theGPHi.addEdge(0, 3); // AD
	theGPHi.addEdge(3, 4); // DE
	System.out.print("Visits: ");
	theGPHi.dfs(); 
	dfsGraph dfsGraph = new dfsGraph(theGPHi);
	
	}
	
}
class StackY
{
private final int SIZE = 20;
private int[] st;
private int top;
// -----------------------------------------------------------
public StackY() // constructor
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
} // end class StackY
////////////////////////////////////////////////////////////////
class Vertex3
{
public char label; // label (e.g. ‘A’)
public boolean wasVisited;
// ------------------------------------------------------------
public Vertex3(char lab) // constructor
{
label = lab;
wasVisited = false;
}
// ------------------------------------------------------------
} // end class Vertex3
////////////////////////////////////////////////////////////////
class GPHi
{
private final int MAX_VERTS = 20;
private Vertex3 Vertex3List[]; // list of vertices
private int adjMat[][]; // adjacency matrix
private int nVerts; // current number of vertices
private StackY theStack;
// -----------------------------------------------------------
public GPHi() // constructor
{
Vertex3List = new Vertex3[MAX_VERTS];
// adjacency matrix
adjMat = new int[MAX_VERTS][MAX_VERTS];
nVerts = 0;
for(int j=0; j<MAX_VERTS; j++) // set adjacency
for(int k=0; k<MAX_VERTS; k++) // matrix to 0
adjMat[j][k] = 0;
theStack = new StackY();
} // end constructor
// -----------------------------------------------------------
public void addVertex3(char lab)

{
Vertex3List[nVerts++] = new Vertex3(lab);
}
// -----------------------------------------------------------
public void addEdge(int start, int end)
{
adjMat[start][end] = 1;
adjMat[end][start] = 1;
}
public int numver(){
	return nVerts;
}
// ------------------------------------------------------------
public void displayVertex3(int v)
{
System.out.print(Vertex3List[v].label);
}
public void dfs() // depth-first search
{ // begin at Vertex3 0
	Vertex3List[0].wasVisited = true; // mark it
	displayVertex3(0); // display it
	theStack.push(0); // push it
	while( !theStack.isEmpty() ) // until stack empty,
	{
		// get an unvisited Vertex3 adjacent to stack top
		int v = getAdjUnvisitedVertex3( theStack.peek() );
		if(v == -1) // if no such Vertex3,
			theStack.pop();
		else // if it exists,
		{
		Vertex3List[v].wasVisited = true; // mark it
		displayVertex3(v); // display it
		theStack.push(v); // push it
}
} // end while
// stack is empty, so we’re done
for(int j=0; j<nVerts; j++) // reset flags
Vertex3List[j].wasVisited = false;
}
public int getAdjUnvisitedVertex3(int v)
{
	for(int j=0; j<nVerts; j++)
		if(adjMat[v][j]==1 && Vertex3List[j].wasVisited==false)
		return j;
		return -1;
	} 
}
class dfsGraph
{
   private GPHi G;
   private int nVerts, time;				// number of vertices, time
   private int [] color;
   private int [] pie;

   public dfsGraph(GPHi G)
   {
   	// declare variables
	int u;
	int WHITE=0;

        nVerts = G.numver(); 				// get number of vertices in the graph class

        // initialize arrays
        color = new int[nVerts];
        pie = new int[nVerts];

        for(u=0; u<nVerts; u++)
        {
        	color[u] = WHITE;;
        	pie[u] = -1;

        }// end for

        time = 0;

        for(u=0; u<nVerts; u++)
        {
        	if(color[u] == WHITE)
                	DFS_Visit(u);

        }// end for

    }// end bfs_function()

//--------------------------------------------------------------
   public void DFS_Visit(int u)
   {
   	// declare variables
   	int WHITE=0, GRAY=1, BLACK=2, v;
   	int [] d;
	int [] f;

	// initialize arrays
        d = new int[nVerts];
        f = new int[nVerts];

	color[u] = GRAY;  				// white vertex u has just been discovered

	d[u] = time + 1;

        v = G.getAdjUnvisitedVertex3(u);

        while(v != -1)
        {
        	if(color[v] == WHITE)
                {
                	pie[v] = u;
                	DFS_Visit(v);

                }// end if

                v = G.getAdjUnvisitedVertex3(u);

        }// end while

        color[u] = BLACK;					// blackened u, it is finished

        f[u] = time + 1;

        System.out.println("");    				// display the array d
    	for(int row=0; row<nVerts; row++)
      	{
      		System.out.print(d[row] + " ");
      	  	System.out.println("");
      	}// end for

   }// end dfsGraph()
//--------------------------------------------------------------
}//end class dfs
