package org.jfree.data;
import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class RangeTest {
	
@Rule
public ExpectedException thrown = ExpectedException.none();

private Range exampleRange1, exampleRange2, exampleRange3, exampleRange4, exampleRange5, exampleRange6, range, range1, range2, range3, range4, range5, range6;
@BeforeClass public static void setUpBeforeClass() throws Exception {
}
@Before
public void setUp() throws Exception {
	exampleRange1 = new Range(5, 10);
	exampleRange2 = new Range(-2, 3);
	exampleRange3 = null;
	exampleRange4 = new Range(1,7);
	exampleRange5 = new Range(6,9);
	exampleRange6 = new Range (5,10);
	range         = new Range(0, 10);
	range1 = new Range(1, 10);
    range2 = new Range(-5, 5);
    range3 = new Range(0, 0);
    range4 = new Range(1, 1);
    range5 = new Range(0, 10);
}


/*
* Tests for method toString
* 1 test
*/
@Test
public void testToString() {
//String expected = "Range[5,10]";
//String result = exampleRange1.toString();
assertEquals("The new range should be (5, 10)", exampleRange6, exampleRange1.toString());
//assertEquals(expected, result);
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
/*
* Tests for method Equals
* 3 tests
*/
@Test
public void testEqualsWithEquivalentObject() {
	Range tempRange = new Range(5,10);
	assertTrue(exampleRange1.equals(tempRange));
}
@Test
public void testEqualsWithNonEquivalentObject() {
	assertFalse(exampleRange2.equals(exampleRange1));
}
@Test
public void testEqualsWithNullObject() {
	assertFalse(exampleRange1.equals(exampleRange3));	
}
@Test
public void testIntersects_Overlap_LowerBound_UpperBound() {
    Range range1 = new Range(0, 5);
    //Range range2 = new Range(3, 8);

    assertTrue(range1.intersects(3,8));
}

@Test
public void testIntersects_Overlap_LowerBound() {
    Range range1 = new Range(0, 5);
    //Range range2 = new Range(3, 8);
    System.out.println(range1.intersects(3, 5));
    assertTrue(range1.intersects(3, 5));
}

@Test
public void testIntersects_Overlap_UpperBound() {
    Range range1 = new Range(0, 5);
    //Range range2 = new Range(3, 8);
    
    
    assertTrue(range1.intersects(0, 3));
}

@Test
public void testIntersects_CompleteOverlap() {
    Range range1 = new Range(0, 5);
    //Range range2 = new Range(3, 8);

    System.out.println(range1.intersects(0, 5));
    assertTrue(range1.intersects(0, 5));
}

@Test
public void testIntersects_NoOverlap_GreaterThan() {
    Range range1 = new Range(0, 5);
    //Range range2 = new Range(6, 10);

    assertFalse(range1.intersects(6, 10));
}

@Test
public void testIntersects_NoOverlap_LessThan() {
    Range range1 = new Range(0, 5);
    //Range range2 = new Range(-2, -1);

    assertFalse(range1.intersects(-2, -1));
}

@Test
public void testIntersects_IdenticalRanges() {
    Range range5 = new Range(5, 5);

    assertTrue(range5.intersects(5, 5));
}

@Test
public void testGetUpperBound() {
    Range range = new Range(0, 5);
    //System.out.println(range.getUpperBound());
    assertEquals(5.0, range.getUpperBound(), 0);
}

//New Tests
///////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//LowerBound

@Test
public void testGetLowerBound() {
    double lowerBound = range.getLowerBound();

    // Test that the returned lower bound is correct
    assertEquals(0.0, lowerBound, 0.01);
}

@Test
public void testGetLowerBoundForNegativeLowerBound() {
    // Create a Range object with lower bound = -10 and upper bound = 10
    range = new Range(-10, 10);

    double lowerBound = range.getLowerBound();

    // Test that the returned lower bound is correct
    assertEquals(-10.0, lowerBound, 0.01);
}

@Test
public void testGetLowerBoundForZeroLowerBound() {
    // Create a Range object with lower bound = 0 and upper bound = 10
    range = new Range(0, 10);

    double lowerBound = range.getLowerBound();

    // Test that the returned lower bound is correct
    assertEquals(0.0, lowerBound, 0.01);
}

@Test
public void testGetLowerBoundForUpperBoundEqualToLowerBound() {
    // Create a Range object with lower bound = 10 and upper bound = 10
    range = new Range(10, 10);

    double lowerBound = range.getLowerBound();

    // Test that the returned lower bound is correct
    assertEquals(10.0, lowerBound, 0.01);
}

@Test
public void testGetLowerBoundForPositiveLowerBound() {
    // Create a Range object with lower bound = 5 and upper bound = 10
    range = new Range(5, 10);

    double lowerBound = range.getLowerBound();

    // Test that the returned lower bound is correct
    assertEquals(5.0, lowerBound, 0.01);
}


//GetLength///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Test
public void testGetLength() {
    double length = range.getLength();

    // Test that the returned length is correct
    assertEquals(10.0, length, 0.01);
}

@Test
public void testGetLengthForNegativeRange() {
    // Create a Range object with lower bound = -10 and upper bound = -5
    range = new Range(-10, -5);

    double length = range.getLength();

    // Test that the returned length is correct
    assertEquals(5.0, length, 0.01);
}

@Test
public void testGetLengthForZeroRange() {
    // Create a Range object with lower bound = 0 and upper bound = 0
    range = new Range(0, 0);

    double length = range.getLength();

    // Test that the returned length is correct
    assertEquals(0.0, length, 0.01);
}

@Test
public void testGetLengthForUpperBoundEqualToLowerBound() {
    // Create a Range object with lower bound = 10 and upper bound = 10
    range = new Range(10, 10);

    double length = range.getLength();

    // Test that the returned length is correct
    assertEquals(0.0, length, 0.01);
}

@Test
public void testGetLengthForPositiveRange() {
    // Create a Range object with lower bound = 5 and upper bound = 10
    range = new Range(5, 10);

    double length = range.getLength();

    // Test that the returned length is correct
    assertEquals(5.0, length, 0.01);
}


//Range Constructor////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Test for a valid range with lower bound < upper bound
@Test
public void testValidRangeWithLowerBoundLessThanUpperBound() {
    Range range = new Range(0, 10);
    assertNotNull(range);
}

// Test for a valid range with lower bound = upper bound
@Test
public void testValidRangeWithLowerBoundEqualsUpperBound() {
    Range range = new Range(10, 10);
    assertNotNull(range);
}

// Test for a valid range with negative values
@Test
public void testValidRangeWithNegativeValues() {
    Range range = new Range(-10, -5);
    assertNotNull(range);
}

// Test for a valid range with zero values
@Test
public void testValidRangeWithZeroValues() {
    Range range = new Range(0, 0);
    assertNotNull(range);
}

// Test for an invalid range with lower bound > upper bound
@Test
public void testInvalidRangeWithLowerBoundGreaterThanUpperBound() {
    thrown.expect(IllegalArgumentException.class);
    
}

// Test for an invalid range with lower bound = NaN
@Test
public void testInvalidRangeWithLowerBoundAsNaN() {
    thrown.expect(IllegalArgumentException.class);
    new Range(Double.NaN, 10);
}

// Test for an invalid range with upper bound = NaN
@Test
public void testInvalidRangeWithUpperBoundAsNaN() {
    thrown.expect(IllegalArgumentException.class);
    new Range(0, Double.NaN);
}



// Test for an invalid range with upper bound = POSITIVE_INFINITY
@Test
public void testInvalidRangeWithUpperBoundAsPositiveInfinity() {
    thrown.expect(IllegalArgumentException.class);
    new Range(0, Double.POSITIVE_INFINITY);
}

// Test for an invalid range with lower bound = NEGATIVE_INFINITY
@Test
public void testInvalidRangeWithLowerBoundAsNegativeInfinity() {
    thrown.expect(IllegalArgumentException.class);
    new Range(Double.NEGATIVE_INFINITY, 10);
}


//Get Central Value//////////////////////////////////////////////////////////////////////////////////////////////////////////
@Test
public void testGetCentralValueRange1() {
    // Test range [1, 10]
    double expected = 5.5;
    double actual = range1.getCentralValue();
    assertEquals(expected, actual, 0.01); // Equivalent class: non-empty range with odd number of elements
}

@Test
public void testGetCentralValueRange2() {
    // Test range [-5, 5]
    double expected = 0;
    double actual = range2.getCentralValue();
    assertEquals(expected, actual, 0.01); // Equivalent class: non-empty range with even number of elements
}

@Test
public void testGetCentralValueRange3() {
    // Test range [0, 0]
    double expected = 0;
    double actual = range3.getCentralValue();
    assertEquals(expected, actual, 0.01); // Equivalent class: single element range
}


//contains//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Test
public void testContainsInRange1() {
    // Test range [1, 10]
    double value = 5;
    assertTrue(range1.contains(value)); // Equivalent class: value within range
}

@Test
public void testContainsOutOfRange1() {
    // Test range [1, 10]
    double value = 11;
    assertFalse(range1.contains(value)); // Equivalent class: value outside range
}

@Test
public void testContainsInRange2() {
    // Test range [-5, 5]
    double value = 0;
    assertTrue(range2.contains(value)); // Equivalent class: value within range
}

@Test
public void testContainsOutOfRange2() {
    // Test range [-5, 5]
    double value = 6;
    assertFalse(range2.contains(value)); // Equivalent class: value outside range
}

@Test
public void testContainsSingleElementRange() {
    // Test range [0, 0]
    double value = 0;
    assertTrue(range3.contains(value)); // Equivalent class: value within single element range
}

@Test
public void testContainsValueBelowRange() {
    // Test range [1, 10]
    double value = 0;
    assertFalse(range1.contains(value)); // Equivalent class: value below range
}

@Test
public void testContainsValueAboveRange() {
    // Test range [1, 10]
    double value = 12;
    assertFalse(range1.contains(value)); // Equivalent class: value above range
}


//constrain/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Test
public void testConstrainInRange1() {
    // Test range [1, 10]
    double value = 5;
    assertEquals(value, range1.constrain(value), 0.001); // Equivalent class: value within range
}

@Test
public void testConstrainOutOfRange1Lower() {
    // Test range [1, 10]
    double value = 0;
    assertEquals(1, range1.constrain(value), 0.001); // Equivalent class: value below range
}

@Test
public void testConstrainOutOfRange1Upper() {
    // Test range [1, 10]
    double value = 11;
    assertEquals(10, range1.constrain(value), 0.001); // Equivalent class: value above range
}

@Test
public void testConstrainInRange2() {
    // Test range [-5, 5]
    double value = -3;
    assertEquals(value, range2.constrain(value), 0.001); // Equivalent class: value within range
}

@Test
public void testConstrainOutOfRange2Lower() {
    // Test range [-5, 5]
    double value = -10;
    assertEquals(-5, range2.constrain(value), 0.001); // Equivalent class: value below range
}

@Test
public void testConstrainOutOfRange2Upper() {
    // Test range [-5, 5]
    double value = 10;
    assertEquals(5, range2.constrain(value), 0.001); // Equivalent class: value above range
}

@Test
public void testConstrainInRange3() {
    // Test range [0, 0]
    double value = 0;
    assertEquals(value, range3.constrain(value), 0.001); // Equivalent class: single value range
}

@Test
public void testConstrainOutOfRange3() {
    // Test range [0, 0]
    double value = 5;
    assertEquals(0, range3.constrain(value), 0.001); // Equivalent class: value outside range (always return the central value)
}


//expandToInclude/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Test
public void testExpandToInclude1() {
    // Test expanding range [1, 10] to include value 5
    Range expandedRange = Range.expandToInclude(range1, 5);
    assertEquals(1, expandedRange.getLowerBound(), 0.001); // Equivalent class: range with non-zero lower bound
    assertEquals(10, expandedRange.getUpperBound(), 0.001); // Equivalent class: range with non-zero upper bound
}

@Test
public void testExpandToInclude2() {
    // Test expanding range [-5, 5] to include value 10
    Range expandedRange = Range.expandToInclude(range2, 10);
    assertEquals(-5, expandedRange.getLowerBound(), 0.001); // Equivalent class: range with negative lower bound
    assertEquals(10, expandedRange.getUpperBound(), 0.001); // Equivalent class: value is outside the original range
}

@Test
public void testExpandToInclude3() {
    // Test expanding range [0, 0] to include value 0
    Range expandedRange = Range.expandToInclude(range3, 0);
    assertEquals(0, expandedRange.getLowerBound(), 0.001); // Equivalent class: single value range
    assertEquals(0, expandedRange.getUpperBound(), 0.001);
}

@Test
public void testExpandToInclude4() {
    // Test expanding range [1, 1] to include value 0
    Range expandedRange = Range.expandToInclude(range4, 0);
    assertEquals(0, expandedRange.getLowerBound(), 0.001); // Equivalent class: value is lower than the original lower bound
    assertEquals(1, expandedRange.getUpperBound(), 0.001);
}

@Test
public void testExpandToInclude5() {
    // Test expanding null range to include value 5
    Range expandedRange = Range.expandToInclude(range6, 5);
    assertEquals(5, expandedRange.getLowerBound(), 0.001); // Equivalent class: null range
    assertEquals(5, expandedRange.getUpperBound(), 0.001);
}

@Test(expected = NullPointerException.class)
public void testExpandToInclude6() {
    // Test exception for null input range
    Range.expandToInclude(null, 5);
}






@After
public void tearDown() throws Exception {
}
@AfterClass
public static void tearDownAfterClass() throws Exception {
}
}

