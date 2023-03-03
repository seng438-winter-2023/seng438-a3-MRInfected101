package org.jfree.data;
import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTestMethodCombine {
	private Range exampleRange1, exampleRange2, exampleRange3, exampleRange4;
	private Range exampleRange5;
	@BeforeClass public static void setUpBeforeClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
		exampleRange1 = new Range(5, 10);
		exampleRange2 = new Range(-2, 3);
		exampleRange3 = null;
		exampleRange4 = new Range(1,7);
		exampleRange5 = new Range(6,9);
		
	}

/*
* Tests for method Combine
* 10 tests
*/
	@Test
	public void testCombineWithRange1InsideRange2() {
		assertEquals("The new range should be (5, 10)", exampleRange1, Range.combine(exampleRange5, exampleRange1));
	}
/* Test combines Range 1 = (5,10)
* 				 Range 2 = (6,9)
* Test produces an error:
* IllegalArgumentException: Range(double,double): require lower (6.0) <= upper (5.0)
*/
	@Test
	public void testCombineWithRange2InsideRange1() {
		assertEquals("The new range should be (5, 10)", exampleRange1, Range.combine(exampleRange1, exampleRange5));
	}
/* Test combines Range 1 = (1,7)
* 				 Range 2 = (5,10)
* Test produces an error:
* IllegalArgumentException: Range(double,double): require lower (5.0) <= upper (1.0)
*/
	@Test
	public void testCombineWithLowRange1IntersectHighRange2() {
		Range result = new Range(1,10);
		assertEquals("The new range should be (1, 10)", result, Range.combine(exampleRange4, exampleRange1));
	}
	@Test
	public void testCombineWithHighRange1IntersectWithLowRange2() {
		Range result = new Range(1,10);
		assertEquals("The new range should be (1, 10)", result, Range.combine(exampleRange1, exampleRange4));
	}
	@Test
	public void testCombineRange1EqualsRange2() {
		assertEquals("The new range should be (1, 7)", exampleRange4, Range.combine(exampleRange4, exampleRange4));
	}
/* Test combines Range 1 = (-2,3)
* 				 Range 2 = (5,10)
* Test produces an error:
* IllegalArgumentException: Range(double,double): require lower (5.0) <= upper (-2.0)
*/
	@Test
	public void testCombineLowRange1HighRange2() {
		Range result = new Range(-2,10);
		assertEquals("The new range should be (-2, 10)", result, Range.combine(exampleRange2, exampleRange1));
	}
	@Test
	public void testCombineHighRange1LowRange2() {
		Range result = new Range(-2,10);
		assertEquals("The new range should be (-2, 10)", result, Range.combine(exampleRange1, exampleRange2));
	}
	@Test
	public void testCombineWithNullRange1() {
		assertEquals("The new range should be (-2, 3)", exampleRange2, Range.combine(exampleRange3, exampleRange2));
	}
	@Test
	public void testCombineWithNullRange2() {
		assertEquals("The new range should be (5, 10)", exampleRange1, Range.combine(exampleRange1, exampleRange3));
	}
	@Test
	public void testCombineWithBothNullRanges() {
		assertEquals("The new range should be null", null, Range.combine(exampleRange3, exampleRange3));
	}


	@After
	public void tearDown() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
