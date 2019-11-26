package datastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class manage the necessary attributes and methods to test the datastructures class AdjacencyMatrixGraph
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class UnionFindTest {

	private UnionFind disjointset;
	
	/**
	 * This scenary is useful when previous objects do not need to be created before testing a function of the system
	 */
	private void setUpScenary1() {
		//Empty
	}
	
	private void setUpScenary2() {
		disjointset = new UnionFind(5);
	}
	
	private void setUpScenary3() {
		disjointset = new UnionFind(5);
		disjointset.union(2, 1);
		disjointset.union(0, 4);
	}
	
	@Test
	/**
	 * This method test the constructor of the datastructures class "Union-Find" making sure a disjoint set can be created with the
	 * right values
	 * <b>Pos:</b> The disjoint set has been created correctly, is not null and it has the expected sets.
	 */
	public void testUnionFind() {
		setUpScenary1();
		
		UnionFind disjointset = new UnionFind(10);
		assertNotNull(disjointset, "The set is null");
		assertNotNull(disjointset.getParent(), "The parents set is null");
		assertNotNull(disjointset.getRank(), "The sets are null");
		
		assertEquals(10,disjointset.getParent().length,"The size of this set is not the expected one");
		assertEquals(10,disjointset.getRank().length,"The size of this set is not the expected one");
	}
		
	@Test
	/**
	 * This method test the Union method of the datastructures class "Union-Find" making sure that for a given elements
	 * an union between their sets can be made.
	 * <b>Pos:</b> The elements union was succesfull, the new resultant disjoint-set is not empty
	 */
	public void testUnion() {
		setUpScenary2();
		disjointset.union(0, 3);
		assertEquals(0,disjointset.find(0),"The set was not united");
		assertEquals(0,disjointset.find(3),"The set was not united");
		
		disjointset.union(1, 4);
		assertEquals(1,disjointset.find(1),"The set was not united");
		assertEquals(1,disjointset.find(4),"The set was not united");

	}
	
	@Test
	/**
	 * This method test the find method of the datastructures class "Union-Find" making sure that for a given element
	 * it can be obtained the current representant of its set
	 * <b>Pos:</b> The element's representant has been found correctly, exists and makes part of a non-empty set.
	 */
	public void testFind() {
		setUpScenary2();
		for (int i = 0; i < disjointset.getParent().length; i++) {
			assertEquals(i,disjointset.find(i),"The set could not been found");
		}
		setUpScenary3();
		assertEquals(2,disjointset.find(1),"The set was not united");
		assertEquals(2,disjointset.find(2),"The set was not united");
		assertEquals(0,disjointset.find(4),"The set was not united");
		assertEquals(0,disjointset.find(0),"The set was not united");
	}
}