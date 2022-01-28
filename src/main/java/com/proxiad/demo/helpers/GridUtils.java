package com.proxiad.demo.helpers;

import com.proxiad.demo.game.Cell;
import com.proxiad.demo.game.CellState;
import com.proxiad.demo.game.Grid;

public class GridUtils {
	private static final String ALIVE = "x";
	private static final String DEAD = "o";

	public static Grid toGrid(String[][] str) {
		if (str == null) {
			return new Grid(null);
		}
		Cell[][] cells = new Cell[str.length][str[0].length];
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[0].length; j++) {
				Cell newCell = null;
				if (str[i][j].equals(ALIVE)) {
					newCell = new Cell(CellState.ALIVE);
				} else {
					newCell = new Cell(CellState.DEAD);
				}
				cells[i][j] = newCell;
			}
		}
		return new Grid(cells);
	}

	public static String[][] toString(Grid grid) {
		Cell[][] cells = grid.getCells();
		if (cells == null) {
			return null;
		}
		String[][] result = new String[cells.length][cells[0].length];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				String newCell = null;
				if (cells[i][j].state().equals(CellState.ALIVE)) {
					newCell = ALIVE;
				} else {
					newCell = DEAD;
				}
				result[i][j] = newCell;
			}
		}
		return result;
	}
}
