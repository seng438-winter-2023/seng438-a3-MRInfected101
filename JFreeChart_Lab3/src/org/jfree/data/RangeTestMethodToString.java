package org.jfree.data;
import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
public class RangeTestMethodToString {
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
* Tests for method toString
* 4 tests
*/
	@Test
	public void testToStringBothPositive() {
		String expected = "Range[5.0,10.0]";
		String result = exampleRange1.toString();
		assertEquals(expected, result);
	}
	@Test
	public void testToStringNegativeAndPositive() {
		String expected = "Range[-2.0,3.0]";
		String result = exampleRange2.toString();
		assertEquals(expected, result);
	}
	@Test
	public void testToStringBothNegative() {
		String expected = "Range[-10.0,-5.0]";
		String result = exampleRange6.toString();
		assertEquals(expected, result);
	}
	@Test
	public void testToStringSameValue() {
		String expected = "Range[2.0,2.0]";
		String result = exampleRange7.toString();
		assertEquals(expected, result);
	}

	@After
	public void tearDown() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
