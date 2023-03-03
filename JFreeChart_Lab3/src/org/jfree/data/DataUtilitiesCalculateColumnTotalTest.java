package org.jfree.data;

import org.jmock.Mockery;
import static org.junit.Assert.*;
import org.junit.Test;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;

public class DataUtilitiesCalculateColumnTotalTest {
	@Test
	public void calculateColumnTotalForTwoValues() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(result, 10.0, .000000001d);
		// tear-down: NONE in this test method
	}

	/**
	 * Throwing a org.jmock.api.ExpectationError instead of the expected
	 * java.lang.IndexOutOfBoundsException that should be thrown because the array
	 * is of size 3 and we are trying to access a value that would only be
	 * accessible in an array of size 4 or greater
	 * 
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateColumnTotalForInvalidValuesAndRange() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 0);
				will(returnValue(6.0));
				one(values).getValue(1, 0);
				will(returnValue(null));
				one(values).getValue(2, 0);
				will(returnValue(1.0));
				one(values).getValue(3, 0);
				will(returnValue(5.5));
			}

		});

		double result = DataUtilities.calculateColumnTotal(values, 0);

		assertEquals(result, 0, .000000001d);

	}

	/**
	 * 
	 * Test fails but produces the expected output of a IndexOutOfBoundsExpectation
	 * 
	 */

	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateColumnTotalForInvalidRange() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(1));
				one(values).getValue(0, 0);
				will(returnValue(2.0));
				one(values).getValue(1, 0);
				will(returnValue(6.0));

			}

		});
		double result = DataUtilities.calculateColumnTotal(values, 0);

		assertEquals(result, 2.0, .000000001d);
	}

	/**
	 * Failure trace says that it expects the value of result to be 5.5 but was 0.0,
	 * which is expected because of the null input, but I am not sure as to why it
	 * is expecting a result of 5.5 when null added with any value is supposed to
	 * output 0 according to the documentation
	 */

	@Test
	public void calculateColumnTotalForInvalidValues() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(4.5));
				one(values).getValue(1, 0);
				will(returnValue(null));
			}
		});

		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(result, 0.0, .000000001d);
	}

}
