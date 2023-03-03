package org.jfree.data;

import static org.junit.Assert.*;
import org.jmock.Mockery;
import org.jmock.Expectations;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

import java.security.InvalidParameterException;

public class DataUtilitiesCalculateRowTotalTest {
  @Test
  public void testRowTotalValidInputs() {
    Mockery mockingContext = new Mockery();

    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {
      {
        one(values).getColumnCount();
        will(returnValue(2));
        one(values).getValue(0, 0);
        will(returnValue(3.4));
        one(values).getValue(0, 1);
        will(returnValue(4.1));
      }
    });

    double result = DataUtilities.calculateRowTotal(values, 0);
    assertEquals("Checking getRowTotal with valid Values2D and column values",
        7.5,
        result,
        .000000001d
    );
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testRowTotalInvalidValues2D() {
    Mockery mockingContext = new Mockery();

    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {
      {
        one(values).getColumnCount();
        will(returnValue(10));
        one(values).getValue(0,0);
        will(returnValue(1.1));
        one(values).getValue(0,1);
        will(returnValue(2.2));
      }
    });

    thrown.expect(InvalidParameterException.class);

    DataUtilities.calculateRowTotal(values, 0);
  }

  @Test
  public void testRowTotalInvalidRowIndex() {
    Mockery mockingContext = new Mockery();

    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {
      {
        one(values).getColumnCount();
        will(returnValue(2));
        one(values).getValue(0,0);
        will(returnValue(1.1));
        one(values).getValue(0,1);
        will(returnValue(2.2));
      }
    });

    thrown.expect(InvalidParameterException.class);

    DataUtilities.calculateRowTotal(values, 10);
  }

  @Test
  public void testRowTotalAllInvalidParameters() {
    Mockery mockingContext = new Mockery();

    final Values2D values = mockingContext.mock(Values2D.class);
    mockingContext.checking(new Expectations() {
      {
        one(values).getColumnCount();
        will(returnValue(10)); // this makes it invalid as there are only 2
                               // columns
        one(values).getValue(0,0);
        will(returnValue(1.1));
        one(values).getValue(0,1);
        will(returnValue(2.2));
      }
    });
    thrown.expect(InvalidParameterException.class);

    DataUtilities.calculateRowTotal(values, 10);
  }

}

