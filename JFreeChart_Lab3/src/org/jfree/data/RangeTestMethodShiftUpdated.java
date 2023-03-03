package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTestMethodShiftUpdated {
  private Range exampleRange1, exampleRange2, exampleRange3, exampleRange4;
  @BeforeClass public static void setUpBeforeClass() throws Exception {}

  @Test
  public void testShiftUpBothPositive() {
    Range testRange = new Range(5, 10);
    Range expectedRange = new Range(13, 18);

    Range result = Range.shift(testRange, 8);
    assertEquals("The new range should be (13, 18) when shifted by 8", expectedRange, result);
  }

  @Test
  public void testShiftUpBothNegative() {
    Range testRange = new Range(-10, -5);
    Range expectedRange = new Range(-2, 3);

    Range result = Range.shift(testRange, 8);
    assertEquals("The new range should be (-2, 3) when shifted by 8", expectedRange, result);
  }

  @Test
  public void testShiftUpBothNegativeAndPositive() {
    Range testRange = new Range(-2, 3);
    Range expectedRange = new Range(6, 11);

    Range result = Range.shift(testRange, 8);
    assertEquals("The new range should be (6, 11) when shifted by 8", expectedRange, result);
  }

  @Test
  public void testShiftUpSame() {
    Range testRange = new Range(2,2);
    Range expectedRange = new Range(10, 10);

    Range result = Range.shift(testRange, 8);
    assertEquals("The new range should be (10, 10) when shifted by 8", expectedRange, result);
  }

  @Test
  public void testShiftUpZeroLower() {
    Range testRange = new Range(0, 8);
    Range expectedRange = new Range(8, 16);

    Range result = Range.shift(testRange, 8);
    assertEquals("The new range should be (8, 16) when shifted by 8", expectedRange, result);
  }

  @Test
  public void testShiftDownBothPositive() {
    Range testRange = new Range(5, 10);
    Range expectedRange = new Range(-3, 2);

    Range result = Range.shift(testRange, -8);
    assertEquals("The new range should be (-3, 2) when shifted by -8", expectedRange, result);
  }

  @Test
  public void testShiftDownBothNegative() {
    Range testRange = new Range(-10, -5);
    Range expectedRange = new Range(-18, -13);

    Range result = Range.shift(testRange, -8);
    assertEquals("The new range should be (-18, -13) when shifted by -8", expectedRange, result);
  }

  @Test
  public void testShiftDownBothNegativeAndPositive() {
    Range testRange = new Range(-2, 3);
    Range expectedRange = new Range(-10, -5);

    Range result = Range.shift(testRange, -8);
    assertEquals("The new range should be (-10, -5) when shifted by -8", expectedRange, result);
  }

  @Test
  public void testShiftDownSame() {
    Range testRange = new Range(2,2);
    Range expectedRange = new Range(-6, -6);

    Range result = Range.shift(testRange, -8);
    assertEquals("The new range should be (-6, -6) when shifted by -8", expectedRange, result);
  }

  @Test
  public void testShiftDownZeroLower() {
    Range testRange = new Range(0, 8);
    Range expectedRange = new Range(-8, 0);

    Range result = Range.shift(testRange, -8);
    assertEquals("The new range should be (-8, 0) when shifted by -8", expectedRange, result);
  }

  @Test
  public void testShiftUpBothPositiveZeroCrossing() {
    Range testRange = new Range(5, 10);
    Range expectedRange = new Range(13, 18);

    Range result = Range.shift(testRange, 8, true);
    assertEquals("The new range should be (13, 18) when shifted by 8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpBothNegativeZeroCrossing() {
    Range testRange = new Range(-10, -5);
    Range expectedRange = new Range(-2, 3);

    Range result = Range.shift(testRange, 8, true);
    assertEquals("The new range should be (-2, 3) when shifted by 8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpBothNegativeAndPositiveZeroCrossing() {
    Range testRange = new Range(-2, 3);
    Range expectedRange = new Range(6, 11);

    Range result = Range.shift(testRange, 8, true);
    assertEquals("The new range should be (6, 11) when shifted by 8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpSameZeroCrossing() {
    Range testRange = new Range(2,2);
    Range expectedRange = new Range(10, 10);

    Range result = Range.shift(testRange, 8, true);
    assertEquals("The new range should be (10, 10) when shifted by 8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpZeroLowerZeroCrossing() {
    Range testRange = new Range(0, 8);
    Range expectedRange = new Range(8, 16);

    Range result = Range.shift(testRange, 8, true);
    assertEquals("The new range should be (8, 16) when shifted by 8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpBothPositiveNoZeroCrossing() {
    Range testRange = new Range(5, 10);
    Range expectedRange = new Range(13, 18);

    Range result = Range.shift(testRange, 8, false);
    assertEquals("The new range should be (13, 18) when shifted by 8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpBothNegativeNoZeroCrossing() {
    Range testRange = new Range(-10, -5);
    Range expectedRange = new Range(-2, 0);

    Range result = Range.shift(testRange, 8, false);
    assertEquals("The new range should be (-2, 0) when shifted by 8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpBothNegativeAndPositiveNoZeroCrossing() {
    Range testRange = new Range(-2, 3);
    Range expectedRange = new Range(0, 11);

    Range result = Range.shift(testRange, 8, false);
    assertEquals("The new range should be (0, 11) when shifted by 8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpSameNoZeroCrossing() {
    Range testRange = new Range(2,2);
    Range expectedRange = new Range(10, 10);

    Range result = Range.shift(testRange, 8, false);
    assertEquals("The new range should be (10, 10) when shifted by 8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftUpZeroLowerNoZeroCrossing() {
    Range testRange = new Range(0, 8);
    Range expectedRange = new Range(8, 16);

    Range result = Range.shift(testRange, 8, false);
    assertEquals("The new range should be (8, 16) when shifted by 8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownBothPositiveZeroCrossing() {
    Range testRange = new Range(5, 10);
    Range expectedRange = new Range(-3, 2);

    Range result = Range.shift(testRange, -8, true);
    assertEquals("The new range should be (-3, 2) when shifted by -8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownBothNegativeZeroCrossing() {
    Range testRange = new Range(-10, -5);
    Range expectedRange = new Range(-18, -13);

    Range result = Range.shift(testRange, -8, true);
    assertEquals("The new range should be (-18, -13) when shifted by -8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownBothNegativeAndPositiveZeroCrossing() {
    Range testRange = new Range(-2, 3);
    Range expectedRange = new Range(-10, -5);

    Range result = Range.shift(testRange, -8, true);
    assertEquals("The new range should be (-10, -5) when shifted by -8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownSameZeroCrossing() {
    Range testRange = new Range(2,2);
    Range expectedRange = new Range(-6, -6);

    Range result = Range.shift(testRange, -8, true);
    assertEquals("The new range should be (-6, -6) when shifted by -8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownZeroLowerZeroCrossing() {
    Range testRange = new Range(0, 8);
    Range expectedRange = new Range(-8, 0);

    Range result = Range.shift(testRange, -8, true);
    assertEquals("The new range should be (-8, 0) when shifted by 8 with zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownBothPositiveNoZeroCrossing() {
    Range testRange = new Range(5, 10);
    Range expectedRange = new Range(0, 2);

    Range result = Range.shift(testRange, -8, false);
    assertEquals("The new range should be (0, 2) when shifted by -8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownBothNegativeNoZeroCrossing() {
    Range testRange = new Range(-10, -5);
    Range expectedRange = new Range(-18, -13);

    Range result = Range.shift(testRange, -8, false);
    assertEquals("The new range should be (-18, -13) when shifted by -8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownBothNegativeAndPositiveNoZeroCrossing() {
    Range testRange = new Range(-2, 3);
    Range expectedRange = new Range(-10, 0);

    Range result = Range.shift(testRange, -8, false);
    assertEquals("The new range should be (-10, 0) when shifted by -8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownSameNoZeroCrossing() {
    Range testRange = new Range(2,2);
    Range expectedRange = new Range(0, 0);

    Range result = Range.shift(testRange, -8, false);
    assertEquals("The new range should be (0, 0) when shifted by -8 without zero crossing", expectedRange, result);
  }

  @Test
  public void testShiftDownZeroLowerNoZeroCrossing() {
    Range testRange = new Range(0, 8);
    Range expectedRange = new Range(0, 0);

    Range result = Range.shift(testRange, -8, false);
    assertEquals("The new range should be (0, 0) when shifted by 8 without zero crossing", expectedRange, result);
  }
}
