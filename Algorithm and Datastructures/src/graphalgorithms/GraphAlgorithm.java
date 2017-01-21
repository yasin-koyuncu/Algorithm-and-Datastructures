/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithms;

/**
 *
 * @author yasin93
 */
public class GraphAlgorithm {
    /***           Dijikstras Algoritm             */
    
    public static int next(int[] d, boolean[] taken){
		int dMin=Integer.MAX_VALUE;
		int minIndex=0;
		for(int i=0;i<d.length;i++){
			if(d[i]<dMin&&!taken[i]){
				dMin=d[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	

    
    /***           MINIMAL SPANNING TREE          *////
    
    // Number of vertices in the graph
   // private static final int V=8;
 
    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    public static int minKey(int key[], boolean mstSet[],int len)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < len; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed MST stored in
    // parent[]
    public static void  printMST(int parent[], int graph[][])
    {
        int totalWeight=0;
        //System.out.println("Edge   Weight");
        for (int i = 1; i < graph.length; i++){
            totalWeight+=graph[i][parent[i]];// ALTERNATIVT EJ MÅSTE
            System.out.println("Från Nod: "+(char)(parent[i]+'A')+" till Nod "+(char) (i+'A')+" med vikten  "+
                               graph[i][parent[i]]);
        }
        System.out.println("Total vikt: "+totalWeight);//ALTERNATIVT EJ MÅSTE
    }
 
    // Function to construct and print MST for a graph represented
    //  using adjacency matrix representation
    public static void primMST(int graph[][])
    {
        // Array to store constructed MST
        int parent[] = new int[graph.length];
 
        // Key values used to pick minimum weight edge in cut
        int key[] = new int [graph.length];
 
        // To represent set of vertices not yet included in MST
        boolean mstSet[] = new boolean[graph.length];
 
        // Initialize all keys as INFINITE
        for (int i = 0; i < graph.length; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        // Always include first 1st vertex in MST.
        key[0] = 0;     // Make key 0 so that this vertex is
                        // picked as first vertex
        parent[0] = -1; // First node is always root of MST
 
        // The MST will have V vertices
        for (int count = 0; count < graph.length-1; count++)
        {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet,graph.length);
 
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
 
            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < graph.length; v++)
 
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v]!=0 && mstSet[v] == false &&
                    graph[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
        }
 
        // print the constructed MST
        printMST(parent, graph);
    }
 
    public static void main (String[] args)
    {
        
        System.out.println("=======MINIMUM SPANING TREE====");
        
        int X = Integer.MAX_VALUE;
         int[][] w = {{X, 2, X, X, X, 1, X, X},
                     {2, X, 2, 2, 4, X, X, X},
                     {X, 2, X, X, 3, X, X, 1},
                     {X, 2, X, X, 3, 1, X, X},
                     {X, 4, 3, 3, X, X, 7, X},
                     {1, X, X, 1, X, X, 5, X},
                     {X, X, X, X, 7, 5, X, 6},
                     {X, X, 1, X, X, X, 6, X}};
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
       
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
 
        // Print the solution
        primMST(graph);    ///MINIMAL SPANNING TREE tar slut här
        
        
        /***       Dijikstras algoritm           */
        
        System.out.println("\n\n DIJIKSTRAS ALGORITM \n\n");
        
        int d[]={0,X,X,X,X,X,X,X};
		int p[]=new int[8];
		
		boolean[] taken=new boolean[8];
		
		for(int i=0;i<taken.length;i++){
			taken[i]=false;
		}
		
		for(int i=0;i<d.length;i++){
			int u=next(d,taken);
			taken[u]=true;
			for(int v=0;v<w[u].length;v++){
				if(w[u][v]<X&&d[v]>d[u]+w[u][v]){
					d[v]=d[u]+w[u][v];
					p[v]=u;
				}
			}
		}
		
		for(int i=1;i<d.length;i++){
			System.out.println("Nod "+(char)(i+'A')+" har avstand "+d[i]+" till nod A via: "+(char)(p[i]+'A'));
		}
    
    }
}
