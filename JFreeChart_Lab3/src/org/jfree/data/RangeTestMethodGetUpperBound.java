package org.jfree.data;
import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
public class RangeTestMethodGetUpperBound {
private Range exampleRange1, exampleRange2, exampleRange6, exampleRange7;
@BeforeClass public static void setUpBeforeClass() throws Exception {
}
@Before
public void setUp() throws Exception {
	exampleRange1 = new Range(5, 10);
	exampleRange2 = new Range(-2, 3);
	exampleRange6 = new Range(-10,-5);
	exampleRange7 = new Range(2,2);
}

	/*
	 * Tests for getUpperBound
	 *  4 tests
	 */

	@Test
	public void testGetUpperBoundBothPositive() {
    	
    	assertEquals("Expected output is 10.0", 10.0, exampleRange1.getUpperBound(), 0);
	}
	@Test
	public void testGetUpperBoundNegativeAndPositive() {
    	
    	assertEquals("Expected output is 3.0", 3.0, exampleRange2.getUpperBound(), 0);
	}
	@Test
	public void testGetUpperBoundBothNegative() {
    	
    	assertEquals("Expected output is -5.0", -5.0, exampleRange6.getUpperBound(), 0);
	}
	@Test
	public void testGetUpperBoundSameValue() {
    	
    	assertEquals("Expected output is 2.0", 2.0, exampleRange7.getUpperBound(), 0);
	}

	@After
	public void tearDown() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
