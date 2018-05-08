 package Practise;
class Queue1
{
private final int SIZE = 20;
private int[] queArray;
private int front;
private int rear;
// -------------------------------------------------------------
public Queue1() // constructor
{
queArray = new int[SIZE];
front = 0;
rear = -1;
}
// -------------------------------------------------------------
public void insert(int j) // put item at rear of Queue1
{
if(rear == SIZE-1)
rear = -1;
queArray[++rear] = j;
}
// -------------------------------------------------------------
public int remove() // take item from front of Queue1
{
int temp = queArray[front++];
if(front == SIZE)
front = 0;
return temp;

}
// -------------------------------------------------------------
public boolean isEmpty() // true if Queue1 is empty
{
	return ( rear+1==front || (front+SIZE-1==rear) );
}
// -------------------------------------------------------------
	}
class Vertex
{
public char label; // label (e.g. ‘A’)
public boolean wasVisited;
// -------------------------------------------------------------
public Vertex(char lab) // constructor
{
label = lab;
wasVisited = false;
}
}
class Graph1
{
private final int MAX_VERTS = 20;
private Vertex vertexList[]; // list of vertices
private int adjMat[][]; // adjacency matrix
private int nVerts; // current number of vertices
private Queue1 theQueue1;
// ------------------
public Graph1() // constructor
{
	vertexList = new Vertex[MAX_VERTS];
	// adjacency matrix
	adjMat = new int[MAX_VERTS][MAX_VERTS];
	nVerts = 0;
	for(int j=0; j<MAX_VERTS; j++) // set adjacency
		for(int k=0; k<MAX_VERTS; k++) // matrix to 0
				adjMat[j][k] = 0;
			theQueue1 = new Queue1();
} // end constructor

// -------------------------------------------------------------
public void addVertex(char lab)
{
	vertexList[nVerts++] = new Vertex(lab);
}
// -------------------------------------------------------------
public void addEdge(int start, int end)
{
	adjMat[start][end] = 1;
	adjMat[end][start] = 1;
}
// -------------------------------------------------------------
public void displayVertex(int v)
{
	System.out.print(vertexList[v].label);
}
// -------------------------------------------------------------
public void bfs() // breadth-first search
{ // begin at vertex 0
	vertexList[0].wasVisited = true; // mark it
	displayVertex(0); // display it
	theQueue1.insert(0); // insert at tail
	int v2;
	while( !theQueue1.isEmpty() ) // until Queue1 empty,
	{
		int v1 = theQueue1.remove(); // remove vertex at head
		// until it has no unvisited neighbors
	while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
		{ // get one,
		vertexList[v2].wasVisited = true; // mark it
		displayVertex(v2); // display it
		theQueue1.insert(v2); // insert it
		} 
	}
	for(int j=0; j<nVerts; j++) // reset flags
		vertexList[j].wasVisited = false;
} // end bfs()

// returns an unvisited vertex adj to v

public int getAdjUnvisitedVertex(int v)
{
	for(int j=0; j<nVerts; j++)
		if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
return j;
return -1;
} // end getAdjUnvisitedVertex()
// -------------------------------------------------------------
}
public class BFS {
	public static void main(String[] args)
	{
	Graph1 theGraph1 = new Graph1();
	theGraph1.addVertex('A'); // 0 (start for dfs)
	theGraph1.addVertex('B'); // 1
	theGraph1.addVertex('C'); // 2
	theGraph1.addVertex('D'); // 3
	theGraph1.addVertex('E'); // 4
	theGraph1.addEdge(0, 1); // AB
	theGraph1.addEdge(1, 2); // BC
	theGraph1.addEdge(0, 3); // AD
	theGraph1.addEdge(3, 4); // DE
	System.out.print("Visits: ");
	theGraph1.bfs(); // breadth-first search
	System.out.println();
	} // end main()
}
