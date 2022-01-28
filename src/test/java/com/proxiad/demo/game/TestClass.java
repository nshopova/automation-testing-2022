package com.proxiad.demo.game;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClass {

	@Test
	public void testInt () {
		Assertions.assertThat(2 + 2).isEqualTo(4).isPositive();
	}
	
	@Test
	public void testString() {
		Assertions.assertThat("x" + "y").contains("x").endsWith("y").hasSize(2);
	}
	
	@Test
	public void testCollections() {
		List<String> list = new ArrayList<String>();
		list.add("x");
		list.add("y");
		list.add("z");
		
		Assertions.assertThat(list).anyMatch((el) -> el.length() == 1).contains("y");
	}
}
