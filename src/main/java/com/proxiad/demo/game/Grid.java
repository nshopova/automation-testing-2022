package com.proxiad.demo.game;

public class Grid {
	private Cell[][] cells;
	private LivingRules ruller;

	public Grid(Cell[][] cells) {
		this.cells = cells;
		ruller = new LivingRules();
	}

	public Cell[][] getCells() {
		return cells;
	}

	public Grid getNextGeneration() {
		if (cells == null || cells.length == 0 || cells[0].length == 0) {
			throw new IllegalStateException("The grid should contain at least one row!");
		}

		int rowsCount = cells.length;
		int columnsCount = cells[0].length;

		Cell[][] nextGen = new Cell[rowsCount][columnsCount];

		for (int i = 0; i < rowsCount; i++) {
			for (int j = 0; j < columnsCount; j++) {
				int livingNeighbours = getLivingNeighbours(i, j);
				Cell newCell = ruller.nextState(cells[i][j], livingNeighbours);
				nextGen[i][j] = newCell;
			}
		}

		return new Grid(nextGen);
	}

	private int getLivingNeighbours(int i, int j) {
		return countAliveCell(i - 1, j - 1) + countAliveCell(i, j - 1) + countAliveCell(i + 1, j - 1)
				+ countAliveCell(i - 1, j) + countAliveCell(i + 1, j) + countAliveCell(i - 1, j + 1)
				+ countAliveCell(i, j + 1) + countAliveCell(i + 1, j + 1);
	}

	private int countAliveCell(int i, int j) {
		if (i < 0 || i >= cells.length || j < 0 || j >= cells[0].length) {
			return 0;
		}
		return cells[i][j].state() == CellState.ALIVE ? 1 : 0;
	}

}
