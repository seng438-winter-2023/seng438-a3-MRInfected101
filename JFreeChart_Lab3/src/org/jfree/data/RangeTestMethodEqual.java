package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTestMethodEqual {
  private Range exampleRange1, exampleRange2, exampleRange3, exampleRange4;
  @BeforeClass public static void setUpBeforeClass() throws Exception {}

  @Before
  public void setUp() throws Exception {
    exampleRange1 = new Range(5, 10);
    exampleRange2 = new Range(-2, 3);
    exampleRange3 = null;
    exampleRange4 = new Range(5,10);

  }

  /*
  * Tests for method Equals
  * 3 tests
  */
	@Test
	public void testEqualsWithEquivalentObject() {
		assertTrue("Expected ranges to be equal", exampleRange1.equals(exampleRange4));
	}
	@Test
	public void testEqualsWithNonEquivalentObject() {
		assertFalse("Expected ranges to not be equal", exampleRange2.equals(exampleRange1));
	}
	@Test
	public void testEqualsWithNullObject() {
		assertFalse("Expected ranges to not be equal because of a null range",exampleRange1.equals(exampleRange3));	
	}

	@After
	public void tearDown() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
