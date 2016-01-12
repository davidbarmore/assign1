// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid. Does not make a copy.
	 * 
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * 
	 * @param ch
	 *            char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		// get the dimensions of the grid
		int column_length = this.grid.length;
		int row_length = this.grid[0].length;

		// these variables will store the values of the boundary rows/columns
		int leftmost_column = 0, rightmost_column = 0, topmost_row = 0, bottommost_row = 0;
		// this boolean records whether the program has seen the desired
		// character ch
		// This makes it possible to break out of loops after it has been found,
		// to avoid searching the interior of the rectangle unnecessarily
		boolean found_ch = false;

		// iterate through the array, by rows, starting in top left corner
		for (int row_num = 0; row_num < column_length; row_num++) {
			if (found_ch == true)
				break;
			for (int col_num = 0; col_num < row_length; col_num++) {
				if (found_ch == true)
					break;
				// the first instance of ch that is found in this iteration
				// order must be in the topmost row of the rectangle containing
				// all ch's
				if (this.grid[row_num][col_num] == ch) {
					topmost_row = row_num;
					found_ch = true;
				}
			}
		}

		// if you didn't find the character, return an area of zero, rather than
		// iterate through the array 3 more times to find the other area
		// boundaries
		if (!found_ch)
			return 0;

		// iterate through the array, by rows, starting in bottom left corner
		found_ch = false;
		for (int row_num = column_length - 1; row_num >= 0; row_num--) {
			if (found_ch == true)
				break;
			for (int col_num = 0; col_num < row_length; col_num++) {
				if (found_ch == true)
					break;
				// the first instance of ch that is found in this iteration
				// order must be in the bottommost row of the rectangle
				// containing all ch's
				if (this.grid[row_num][col_num] == ch) {
					bottommost_row = row_num;
					found_ch = true;
				}
			}
		}

		// iterate through the array, by columns, starting in top left corner
		found_ch = false;
		for (int col_num = 0; col_num < row_length; col_num++) {
			if (found_ch == true)
				break;
			for (int row_num = 0; row_num < column_length; row_num++) {
				if (found_ch == true)
					break;
				// the first instance of ch that is found in this iteration
				// order must be in the leftmost column of the rectangle
				// containing all ch's
				if (this.grid[row_num][col_num] == ch) {
					leftmost_column = col_num;
					found_ch = true;
				}
			}
		}

		// iterate through the array, by columns, starting in top right corner
		found_ch = false;
		for (int col_num = row_length - 1; col_num >= 0; col_num--) {
			if (found_ch == true)
				break;
			for (int row_num = 0; row_num < column_length; row_num++) {
				if (found_ch == true)
					break;
				// the first instance of ch that is found in this iteration
				// order must be in the rightmost column of the rectangle
				// containing all ch's
				if (this.grid[row_num][col_num] == ch) {
					rightmost_column = col_num;
					found_ch = true;
				}
			}
		}

		int width = rightmost_column - leftmost_column + 1;
		int height = bottommost_row - topmost_row + 1;

		return width * height;
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * 
	 * @return number of + in grid
	 */
	public int countPlus() {
		// get the dimensions of the grid
		int column_length = this.grid.length;
		int row_length = this.grid[0].length;

		int count_pluses = 0;
		int arm_length;
		boolean isPlus;

		// iterate through all possible centers of plus patterns,
		// i.e. every cell except the edges, since arms must have length > 1
		for (int row_num = 1; row_num < column_length - 1; row_num++) {
			for (int col_num = 1; col_num < row_length - 1; col_num++) {
				// reset isPlus to true for the new center to consider, and the
				// arm length to 1
				isPlus = true;
				arm_length = 1;
				// the center of a possible plus
				char center_ch = this.grid[row_num][col_num];

				// while this is still a potential plus, and the next increment
				// of arm length does not go beyond the boundary of the entire
				// grid, check if the next length of arm makes a valid plus
				while (isPlus && row_num - arm_length >= 0 && row_num + arm_length < column_length
						&& col_num - arm_length >= 0 && col_num + arm_length < row_length) {

					if (this.grid[row_num - arm_length][col_num] != center_ch
							|| this.grid[row_num + arm_length][col_num] != center_ch
							|| this.grid[row_num][col_num - arm_length] != center_ch
							|| this.grid[row_num][col_num + arm_length] != center_ch) {
						isPlus = false;
					} else {
						arm_length++;
					}
				}

				// if all the extention indicies are valid, check that none of
				// these characters match the center
				// in this case, all arms have the same length, so it is a plus
				if (row_num - arm_length >= 0 && row_num + arm_length < column_length && col_num - arm_length >= 0
						&& col_num + arm_length < row_length) {
					if (this.grid[row_num - arm_length][col_num] != center_ch
							&& this.grid[row_num + arm_length][col_num] != center_ch
							&& this.grid[row_num][col_num - arm_length] != center_ch
							&& this.grid[row_num][col_num + arm_length] != center_ch) {
						isPlus = true;
					}
				}
				// if the while loop exits because the potential plus has hit a
				// boundary, check that the non-boundary cells are all different
				// from the center
				// in this case, all arms have the same length, so it is a plus
				if (row_num - arm_length >= 0 && this.grid[row_num - arm_length][col_num] == center_ch)
					isPlus = false;
				if (row_num + arm_length < column_length && this.grid[row_num + arm_length][col_num] == center_ch)
					isPlus = false;
				if (col_num - arm_length >= 0 && this.grid[row_num][col_num - arm_length] == center_ch)
					isPlus = false;
				if (col_num + arm_length < row_length && this.grid[row_num][col_num + arm_length] == center_ch)
					isPlus = false;

				// at this point, isPlus is true iff the current center being
				// considered is really the center of a plus, or a degenerate
				// plus with arms of length 1 (an isolated character)
				// thus, isPlus is true and the arm_length is greater than 1 iff
				// this is really the center of a plus
				// increment the counter accordingly
				if (isPlus && arm_length > 1) {
					count_pluses++;
				}
			}
		}

		return count_pluses; 
	}

}