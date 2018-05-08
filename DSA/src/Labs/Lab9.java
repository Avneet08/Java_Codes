package Labs;
class StackX
{
  private final int SIZE = 1000000;
  private int[] st;
  private int top;

public StackX() 
{
	st = new int[SIZE]; 
	top = -1;
}
// -----------------------------------------------------------
public void push(int j) // put item on stack
{	 st[++top] = j; }
// -----------------------------------------------------------
public int pop() // take item off stack
{ 	return st[top--]; }
// ------------------------------------------------------------
public int peek() // peek at top of stack

{ 	return st[top]; }
// ------------------------------------------------------------
public boolean isEmpty() // true if nothing on stack-
{ 	return (top == -1); }
// ------------------------------------------------------------
} 
class Vertex
{
public int label; 
public boolean wasVisited;
// ------------------------------------------------------------
public Vertex(int lab) // constructor
{
	label = lab;
	wasVisited = false;
}
// ------------------------------------------------------------
} 
class Graph
{
private final int MAX_VERTS = 800;
private Vertex vertexList[]; // list of vertices
private int adjMat[][]; // adjacency matrix
private int nVerts; // current number of vertices
private StackX theStack;
// -----------------------------------------------------------
public Graph() // constructor
{
	vertexList = new Vertex[MAX_VERTS];
// adjacency matrix
	adjMat = new int[MAX_VERTS][MAX_VERTS];
	nVerts = 0;
	theStack = new StackX();
	for(int j=0; j<MAX_VERTS; j++) // set adjacency
		for(int k=0; k<MAX_VERTS; k++) // matrix to 0
			adjMat[j][k] = 0;
			
} // end constructor
// -----------------------------------------------------------
public void addVertex(int lab)

{
	vertexList[nVerts] = new Vertex(lab);
	nVerts++;
}
// -----------------------------------------------------------
public void addEdge(int start, int end)
{
	adjMat[start][end] = 1;
	adjMat[end][start] = 1;
}


public int getAdjUnvisitedVertex(int v){
	for(int j=0; j<nVerts; j++)
		if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
			return j;
	return -1;
}
// ------------------------------------------------------------
public void getLink(){
	for(int i=0;i<nVerts;i++){
		if( vertexList[i].wasVisited==true){
			
			i++;
			}
			else{
				displayVertex(i);
				vertexList[i].wasVisited=true;
				
			}
		
		for(int j=0;j<nVerts;j++){
			if(adjMat[i][j]==1 &&  vertexList[j].wasVisited==false  ){
				
				displayVertex(j);
				vertexList[j].wasVisited=true;
			}
			
	}
}
}
public void dfs() 
{ 
	vertexList[0].wasVisited = true; 
	displayVertex(0);
	theStack.push(0); 
	
	while( !theStack.isEmpty() ) 
	{

			int v = getAdjUnvisitedVertex( theStack.peek() );
			//displayVertex(v);
				if(v == -1) {
					theStack.pop();
					//displayVertex(v);
					}
				else
				{displayVertex(v);
					vertexList[v].wasVisited = true; // mark it
					 // display it
					theStack.push(v); // push it
}
} 
	

	for(int j=0; j<nVerts; j++) {
		vertexList[j].wasVisited = false;}
}

public void displayVertex(int v)
{
System.out.print(vertexList[v].label);
}
// ------------------------------------------------------------

 
} 
public class Lab9
{
public static void main(String[] args)
{
	
Graph theGraph = new Graph();
theGraph.addVertex(1); // 0 (start for dfs)
theGraph.addVertex(2); // 1
theGraph.addVertex(3); // 2
theGraph.addVertex(4); // 3
theGraph.addVertex(5); // 4
theGraph.addVertex(6); // 0 (start for dfs)
theGraph.addVertex(7); // 1
theGraph.addVertex(8); // 2
theGraph.addVertex(9); // 3
theGraph.addVertex(10); // 
theGraph.addEdge(8, 1); // AB
theGraph.addEdge(8, 3); // BC
theGraph.addEdge(7, 4); // AD
theGraph.addEdge(2, 6); // DE
theGraph.addEdge(10, 7); // AB
theGraph.addEdge(10, 9); // BC
theGraph.addEdge(2, 10); // CA
theGraph.addEdge(5, 10); 
/*theGraph.addVertex(0); // 0 (start for dfs)
theGraph.addVertex(1); // 1
theGraph.addVertex(2); // 2
theGraph.addVertex(3); // 3
theGraph.addVertex(4); // 4
theGraph.addEdge(0, 1); // AB
theGraph.addEdge(1, 2); // BC
//theGraph.addEdge(2, 1); // CA
theGraph.addEdge(3, 4); // DE*/


System.out.print("Visits: ");
theGraph.dfs(); // depth-first search
System.out.println();
theGraph.getLink();

   
} 
}