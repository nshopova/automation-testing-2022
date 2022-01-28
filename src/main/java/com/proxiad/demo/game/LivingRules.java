package com.proxiad.demo.game;

public class LivingRules {

	public Cell nextState(Cell cell, int livingNeighbours) {
		if (cell.state() == CellState.ALIVE && (livingNeighbours < 3 || livingNeighbours > 3)) {
			return new Cell(CellState.DEAD);
		}
		if (cell.state() == CellState.DEAD && livingNeighbours == 3) {
			return new Cell(CellState.ALIVE);
		}
		return cell;
	}

}
