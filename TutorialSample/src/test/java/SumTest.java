package test.java;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.java.Sum;

@RunWith(JUnit4.class)
public class SumTest {

	private Sum sum = null;

	@Before
	public void setUp() {
		sum = new Sum();
	}

	@After
	public void cleanUp() {
		sum = null;
	}
	
	
	

	@Test
	public void testAdd_success() {

		int firstInput = 5;
		int secondInput = 10;
		int result = sum.add(firstInput, secondInput);
		Assert.assertEquals(result,firstInput+secondInput);

	}

	@Test
	public void testAdd_failure() {

		int firstInput = 5;
		int secondInput = 10;
		int result = sum.add(firstInput, secondInput);
		Assert.assertEquals(result, (firstInput + secondInput + firstInput));

	}

}
