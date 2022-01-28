package com.proxiad.demo.game;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.proxiad.demo.helpers.RandomGenerator;

public class GridTest {
	
	@Test
	public void testGridNextGen_nullGrid() {
		Grid g = new Grid(null);
		IllegalStateException ex = assertThrows(IllegalStateException.class, () -> g.getNextGeneration());
		
		assertEquals("The grid should contain at least one row!", ex.getMessage());
	}
	
	@Test
	public void testArrays() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		Object[] arr = list.toArray();
		assertArrayEquals(new String[] {"1", "2", "3"}, arr);
	}
	
	@Test
	@Disabled
	public void timeoutTest() throws InterruptedException {
		assertTimeout(Duration.ofSeconds(6), () ->  new RandomGenerator().longExecution(5));
	}
}
