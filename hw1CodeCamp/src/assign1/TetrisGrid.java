//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {

	private boolean[][] grid;

	/**
	 * Constructs a new instance with the given grid. Does not make a copy.
	 * 
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}

	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int num_rows = grid[0].length;
		int num_columns = grid.length;

		int[] rows_to_clear = new int[num_rows];

		// Determine which and how many rows are full, and in need of clearing
		int total_rows_to_clear = find_rows_to_clear(rows_to_clear);

		for (int row = 1; row < num_rows; row++) {
			// Every non-filled row with a row below it will have the same value
			// in its row of rows_to_clear as the row below it does
			// So the if statement below only executes when the row in question
			// will still be in the cleared grid, and may need to be shifted
			// down
			if (rows_to_clear[row] == rows_to_clear[row - 1]) {
				for (int column = 0; column < num_columns; column++) {
					// Shift each non-cleared row down by the number of rows
					// below it being cleared, from bottom to top (to avoid
					// overwriting other rows while shifting down)
					grid[column][row - rows_to_clear[row]] = grid[column][row];
				}
			}
		}

		// Fill in empty rows at the top, for all the rows below that have been
		// cleared and shifted down
		for (int empty_top_row = num_rows - total_rows_to_clear; empty_top_row < num_rows; empty_top_row++) {
			for (int column = 0; column < num_columns; column++) {
				grid[column][empty_top_row] = false;
			}
		}

	}

	/*
	 * Determines which rows of the tetris grid are full, and need to be cleared
	 * 
	 * @param rows_to_clear must be an int array of length num_rows
	 * 
	 * @return the total number of full rows which need to be cleared
	 */
	private int find_rows_to_clear(int[] rows_to_clear) {
		int num_rows = grid[0].length;
		int num_columns = grid.length;
		// total_num_rows_to_clear keeps track of the total number of rows which
		// need to be cleared, below and including the current row
		int total_num_rows_to_clear = 0;

		for (int row = 0; row < num_rows; row++) {
			// Reset fullRow to true for the next row to check
			boolean fullRow = true;
			for (int column = 0; column < num_columns; column++) {
				fullRow = fullRow && grid[column][row];
			}
			// At this point, fullRow is true iff the row is actually full, and
			// in need of clearing
			if (fullRow) {
				total_num_rows_to_clear++;
			}
			// Store the number of rows at or below the current row which need
			// to be cleared, at index 'row' in the supplied array
			rows_to_clear[row] = total_num_rows_to_clear;
		}
		// Return the total number of filled rows which need to be cleared
		// The entries in the array rows_to_clear will also be accessible to the
		// main program, to allow it to determine which rows are the full ones
		// in need of clearing
		return total_num_rows_to_clear;
	}

	/**
	 * Returns the internal 2d grid array.
	 * 
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid;
	}
}
