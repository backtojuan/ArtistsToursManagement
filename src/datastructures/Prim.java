package datastructures;

public class Prim {
	
	private final static int V = 0;
	public int minKey (int key[], Boolean mstSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int i = 0; i < V; i++) {
			if(mstSet[i] == false && key[i]<min) {
				min = key [i];
				min_index = i;
			}
		}
		return min_index;
		
	}
	
	public void printMST(int parent[], int graph[][]) {
		
		for(int i = 1; i<V; i++) {
			System.out.println(parent[i] + "-" + i + "\t" + graph[i][parent[i]]);
		}
	}
	
	public void primtMST(int graph[][]) {
		int parent[] = new int [V];
		int key [] = new int [V];
		Boolean mstSet[] = new Boolean[V];
		
		for(int i = 0; i<V; i++) {
			key[i]=Integer.MAX_VALUE;
			mstSet[i] = false;
			
			key[0]= 0;
			parent[0]=-1;
			for(int count = 0; count < V -1; count++) {
				int u = minKey(key, mstSet);
			}
		}
	}
	}


