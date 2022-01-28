package com.proxiad.demo.game;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.proxiad.demo.helpers.RandomGenerator;

public class LivingRulesTest {
	private static LivingRules rules;
	private Cell aliveCell;
	
	@BeforeAll
	public static void setUp () {
		System.out.println("Execute Before All");
		rules = new LivingRules();
	}
	
	@BeforeEach
	public void init() {
		System.out.println("Execute Before Each");
		aliveCell = new Cell(CellState.ALIVE);
	}
	
	@AfterEach
	public void clean() {
		System.out.println("Execute After Each");
	}
	
	@AfterAll
	public static void cleanUp() {
		System.out.println("Execute After All");
	}

	@Test
	public void firstTest() {
		assertTrue(true);
	}
	
	@Nested
	class TestLiveCellesRulles {
		
		@Test
		@DisplayName("Alive cell with 1 neigbour dies.")
		public void testUnderpopulation_1neighbour() {
			Cell newCell = rules.nextState(aliveCell, 1);
			
			assertEquals(CellState.DEAD, newCell.state(), "The cell should be DEAD.");
		}
		
		@Test
		@Disabled
		@DisplayName("Alive cell with 2 neighbours stays alive.")
		public void testAliveCellStaysAlive_2neughbours() {
			Cell newCell = rules.nextState(aliveCell, 2);
			
			assertEquals(CellState.ALIVE, newCell.state(), "The cell should be ALIVE");
		}
		
		@Test
		@DisplayName("Alive cell with 3 neighbours stays alive.")
		public void testAliveCellStaysAlive_3neughbours() {
			Cell newCell = rules.nextState(aliveCell, 3);
			
			assertEquals(CellState.ALIVE, newCell.state(), "The cell should be ALIVE");
		}
		
		@Test
		@DisplayName("Alive cell with 4 neighbours dies.")
		public void testAliveCellDies_4neughbours() {
			Cell newCell = rules.nextState(aliveCell, 4);
			
			assertEquals(CellState.DEAD, newCell.state(), "The cell should be DEAD");
		}
	}
	
	@RepeatedTest(10) 
	public void testRandomGenerator() {
		RandomGenerator generator = new RandomGenerator();
		Cell cell = generator.randomCell();
		assumeFalse(generator.getRandomInt() < 20);
		
		assertEquals(CellState.DEAD, cell.state());
	}
	
	@Test
	public void testDeadCellRules() {
		Cell deadCell = new Cell(CellState.DEAD);
		Cell avliveCell = new Cell(CellState.ALIVE);
		Cell newCell = rules.nextState(deadCell, 3);
		
		assertNotNull(newCell);
		assertEquals(avliveCell, newCell);
		assertNotEquals(deadCell, newCell);
		
	}
	
	@Test
	public void testDeadCellRules2 () {
		Cell deadCell = new Cell(CellState.DEAD);
		Cell avliveCell = new Cell(CellState.ALIVE);
		Cell newCell = rules.nextState(deadCell, 3);
		
		Assertions.assertThat(rules.nextState(deadCell, 3))
				.isNotNull().isEqualTo(avliveCell).isNotEqualTo(deadCell);
	}
	
	@Test
	public void testAllRules() {
		Cell deadCell = new Cell(CellState.DEAD);
		Cell avliveCell = new Cell(CellState.ALIVE);
		Cell newCell = rules.nextState(deadCell, 3);
		
		assertAll(
				() -> assertNotNull(newCell),
				() -> assertEquals(avliveCell, newCell),
				() -> assertNotEquals(deadCell, newCell)
				);
		
	}
}
