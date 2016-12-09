package test.java;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.Dao;
import main.java.Entity;
import main.java.Service;
import mockit.Mock;
import mockit.MockUp;
import mockit.Verifications;

public class ServiceTest {

	private long id = 4;
	private Service service = null;

	@Before
	public void setUp() {
		service = new Service();
	}

	@After
	public void cleanUp() {
		service = null;
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testFetchKey() {
		service.fetchKey(id);
	}

	@Test
	public void testFetchKey_Mocked() {
		
		new MockUp<Dao>() {
			@Mock
			public Entity findById(long id) {
				return getMockedEntity();
			}
		};
		String actualFetchKey = service.fetchKey(id);
		Entity entity = getMockedEntity();
		String firstName = entity.getFirstName();
		String surName = entity.getSurName();
		String expected = firstName + surName;
		Assert.assertEquals(expected, actualFetchKey);
		
	}

	private Entity getMockedEntity() {
		Entity entity = new Entity();
		entity.setFirstName("firstName");
		entity.setSurName("surName");
		return entity;
	}

	
	
}

