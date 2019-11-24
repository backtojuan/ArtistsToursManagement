package datastructures;

import java.util.Arrays;

/**
 * This class manage the necessary attributes and methods to create union-find objects useful for kruskal algorithm (disjoint set)
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class UnionFind{

	private int[] parent;
	private int[] rank;
	
	/**
	 * <b>Union Find Constructor</b>
	 * This method creates a new disjoint-set represented with static arrays.
	 * the slot int a pos i represents the parent of the set for that number
	 * @param size the size of the set
	 */
	public UnionFind(int size) {
		parent = new int[size];
		rank = new int[size];
		
		//Initialize every set with one unique element
		for(int i=0;i<size;i++) {
			parent[i] = i;
		}
	}
	
	/**
	 * This method finds the parent for a given element key in the set
	 * <b>Pre:</b> The union-find structure exists
	 * <b>Pos:</b> The parent for the given element is found
	 * @param key the given element whose parent needs to be found
	 * @return the parent for the given element
	 */
	public int find(int key) {
		int p = parent[key];
		if(key==p) {
			return key;
		}
		return parent[key] = find(p);
	}
	
	/**
	 * This method makes an union between disjoint sets
	 * <b>Pre:</b> The union-find structure exists
	 * <b>Pos:</b> Two elements are now making part of just one set
	 * @param i the element of the first set
	 * @param j the element of the second set
	 */
	public void union(int i, int j) {
		
		int one = find(i);
		int second = find(j);
		
		if(one == second) return;
		
		if(rank[one] > rank[second]) {
			parent[second] = one;
		}
		else if(rank[second] > rank[one]) {
			parent[one] = second;
		}
		else {
			parent[second] = one;
			rank[one]++;
		}
	}
	
	public String toString() {
		return "<UnionFind\np " + Arrays.toString(parent) + "\nr " + Arrays.toString(rank) + "\n>";
	}
}