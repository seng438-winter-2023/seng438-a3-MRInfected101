package org.jfree.data;
import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
public class RangeTestMethodIntersect {

	@BeforeClass public static void setUpBeforeClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
	
	}


/*
 * tests for intersects
 */
		
	@Test
	public void testIntersects_Overlap_LowerBound_UpperBound() {
    	Range range1 = new Range(0, 5);

    	assertTrue("Expected Ranges to intersect", range1.intersects(-1,8));
	}	


	@Test
	public void testIntersects_Overlap_LowerBound() {
    	Range range1 = new Range(0, 5);

    	assertTrue("Expected Ranges to intersect", range1.intersects(3, 6));
	}


	@Test
	public void testIntersects_Overlap_UpperBound() {
		Range range1 = new Range(0, 5);

    	assertTrue("Expected Ranges to intersect", range1.intersects(-1, 3));
	}


	@Test
	public void testIntersects_CompleteOverlap() {
		Range range1 = new Range(0, 5);

    	assertTrue("Expected Ranges to intersect", range1.intersects(1, 4));
	}


	@Test
	public void testIntersects_NoOverlap_GreaterThan() {
    	Range range1 = new Range(0, 5);

    	assertFalse("Expected Ranges to not intersect", range1.intersects(6, 10));
	}


	@Test
	public void testIntersects_NoOverlap_LessThan() {
    	Range range1 = new Range(0, 5);

    	assertFalse("Expected Ranges to not intersect", range1.intersects(-2, -1));
	}	


	@Test
	public void testIntersects_IdenticalRanges() {
		Range range5 = new Range(5, 5);


    	assertTrue("Expected Ranges to intersect", range5.intersects(5, 5));
	}

	@After
	public void tearDown() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
