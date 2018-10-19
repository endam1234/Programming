
import java.util.ArrayList;

import java.util.Iterator;

import java.util.LinkedList;


public class DAG {

	private int V;           // number of vertices in this digraph
	private int E;                 // number of edges in this digraph
	private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
	private int[] indegree;        // indegree[v] = indegree of vertex v
	private boolean marked[];		//Boolean List to track visited vertices
	private boolean hasCycle;		//True if cycle in graph
    private boolean stack[];		//Order that vertices were visited
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path

	public DAG(int V)
	{
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
	    this.V = V;
	    this.E = 0;
	    indegree = new int[V];
	    marked = new boolean[V];
	    stack = new boolean[V];
	    adj = (ArrayList<Integer>[]) new ArrayList[V];

	    for (int v = 0; v < V; v++) {
	        adj[v] = new ArrayList<Integer>();
	    }              
	}

	public int V() {
		return V;	
	}

	public int E() {
        return E;
	}
	//Adds a directed edge from v->w

	public void addEdge(int v, int w)
	{
	    if((validateVertex(v)>0)&&(validateVertex(w)>0))
	    {
	    	adj[v].add(w);
	    	indegree[w]++;
	    	E++;
	    }

	    else{
	    	System.out.println("Please enter vertices between 0 & n-1");
	    }
	}

	private int validateVertex(int v) {
        if (v < 0 || v >= V)
        	return -1;
        else
        	return 1;
        }

	public int indegree(int v) {
		if(validateVertex(v)<0){
			return -1;
		}
		else{
			return indegree[v];
		}
	}

	//Returns amount of directed edges from vertex v

	public int outdegree(int v) {
		if(validateVertex(v)<0){
			return -1;
		}
		else{
			return adj[v].size();
		}
    }

	public Iterable<Integer> adj(int v)
	{ 
		return adj[v]; 
	}

	
}