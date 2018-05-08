package Practise;
import java.io.*;
import java.util.*;
class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    
    public boolean isEmpty() {
        return first == null;
    }

    
    public int size() {
        return n;
    }
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
public class Graph {
	

	// This class represents a directed graph using adjacency list
	// representation
	
		private int V; // No. of vertices
		private LinkedList<Integer> adj[]; //Adjacency Lists
		
		// Constructor
		Graph(int v)
		{
			V = v;
			adj = new LinkedList[v];
			for (int i=0; i<v; ++i)
				adj[i] = new LinkedList();
		}

		// Function to add an edge into the graph
		void addEdge(int v,int w)
		{
			adj[v].add(w);
		}

		// prints BFS traversal from a given source s
		void BFS(int s)
		{
			// Mark all the vertices as not visited(By default
			// set as false)
			boolean visited[] = new boolean[V];

			// Create a queue for BFS
			LinkedList<Integer> queue = new LinkedList<Integer>();

			// Mark the current node as visited and enqueue it
			visited[s]=true;
			queue.add(s);

			while (queue.size() != 0)
			{
				// Dequeue a vertex from queue and print it
				s = queue.poll();
				System.out.print(s+" ");

				// Get all adjacent vertices of the dequeued vertex s
				// If a adjacent has not been visited, then mark it
				// visited and enqueue it
				Iterator<Integer> i = adj[s].listIterator();
				while (i.hasNext())
				{
					int n = i.next();
					if (!visited[n])
					{
						visited[n] = true;
						queue.add(n);
					}
				}
			}
		}

		// Driver method to
		public static void main(String args[])
		{
			Graph g = new Graph(4);

			g.addEdge(2, 1);
			g.addEdge(1, 2);
			g.addEdge(1, 3);
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			System.out.println("Following is Breadth First Traversal "+
							"(starting from vertex 2)");

			g.BFS(2);
		}
	}

